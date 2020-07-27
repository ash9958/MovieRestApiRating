package com.project.springboot.movieapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.project.springboot.movieapp.dao.MovieDAO;
import com.project.springboot.movieapp.dao.UserMovieRatingsDAO;
import com.project.springboot.movieapp.exceptions.MovieNotFoundException;
import com.project.springboot.movieapp.vo.dto.MovieDto;
import com.project.springboot.movieapp.vo.dto.mapper.MovieDtoMapper;
import com.project.springboot.movieapp.vo.entity.Movie;
import com.project.springboot.movieapp.vo.entity.MovieSummary;
import com.project.springboot.movieapp.vo.entity.User;
import com.project.springboot.movieapp.vo.entity.UserMovieRatings;

@RestController
@RequestMapping("/user")
public class MovieController {

	@Autowired
	private MovieDAO movieDAO;
	
	@Value("${api.key}")
	private String apiKey;
	
	@Autowired
	private RestTemplate restTemplate;
	
	MovieDtoMapper movieDtoMapper = new MovieDtoMapper();
	
	@Autowired
	UserMovieRatingsDAO userMovieRatingsDao;
	
	@GetMapping(value = { "/{userId}/movie/{movieName}" })
	public List<MovieDto> getMovieSearch(@PathVariable Integer userId, @PathVariable String movieName) {
		
		MovieSummary result = restTemplate.getForObject(
				"https://api.themoviedb.org/3/search/movie?api_key="+apiKey+"&query="+movieName, MovieSummary.class);
		if(Objects.nonNull(result))
		{
			return result.getResults();
		}
		else
		{
			throw new MovieNotFoundException("Movie not found - " + movieName);
		}
	}
	
	
	@PostMapping(value = {"/{userId}/movie"})
	public List<MovieDto> getuser(@PathVariable Integer userId, @RequestParam Integer movieId,
			@RequestParam Double myRating)
	{	List<MovieDto> movieDtos;
		if (Objects.nonNull(movieId) && Objects.nonNull(myRating)) {
			 
				MovieDto movieDto = restTemplate.getForObject(
						"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieDto.class);
				if (Objects.nonNull(movieDto)) {
					User userData = new User(userId, "", "");
					Movie movieData = movieDtoMapper.getMovieFromDto(movieDto);
					movieData = movieDAO.save(movieData);
					UserMovieRatings userMovieRating = new UserMovieRatings(userId, movieId, userData, movieData,
							myRating, new Date());
					userMovieRatingsDao.save(userMovieRating);
				}
			
		} else {
			throw new RuntimeException("Movie_Id or My_Rating not found");
		}
		Pageable pageable = PageRequest.of(0, 10);
		List<UserMovieRatings> userMovieRatings = userMovieRatingsDao.findByUserIdOrderByTimestampDesc(userId,
				pageable);
		movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);

		return movieDtos;

		
	}
	@GetMapping(value = { "/{userId}/movies" })
	public List<MovieDto> getUserRatedMovies(@PathVariable Integer userId) {
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();

		List<UserMovieRatings> userMovieRatings = userMovieRatingsDao.findByUserId(userId);

		movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
		return movieDtos;
	}
	@GetMapping(value = { "/{userId}/movies/TopRated" })
	public List<MovieDto> getUserTopRatedMovies(@PathVariable Integer userId) {
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();

		Pageable pageable = PageRequest.of(0, 10);
		List<UserMovieRatings> userMovieRatings = userMovieRatingsDao.findByUserIdOrderByRatingDesc(userId, pageable);

		movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
		return movieDtos;
	}
	@GetMapping(value = { "/{userId}/movies/RecentRated" })
	public List<MovieDto> getUserRecentlyRatedMovies(@PathVariable Integer userId) {
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();

		Pageable pageable = PageRequest.of(0, 10);
		List<UserMovieRatings> userMovieRatings = userMovieRatingsDao.findByUserIdOrderByTimestampDesc(userId, pageable);

		movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
		return movieDtos;
	}

}
