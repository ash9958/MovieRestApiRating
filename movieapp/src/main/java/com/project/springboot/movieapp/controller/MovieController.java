package com.project.springboot.movieapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.springboot.movieapp.dao.MovieDAO;
import com.project.springboot.movieapp.dao.UserDAO;
import com.project.springboot.movieapp.dao.UserMovieRatingsDAO;
import com.project.springboot.movieapp.exceptions.MovieNotFoundException;
import com.project.springboot.movieapp.vo.dto.MovieDto;
import com.project.springboot.movieapp.vo.dto.mapper.MovieDtoMapper;
import com.project.springboot.movieapp.vo.entity.Movie;
import com.project.springboot.movieapp.vo.entity.MovieSummary;
import com.project.springboot.movieapp.vo.entity.User;
import com.project.springboot.movieapp.vo.entity.UserMovieRatings;

@RestController
public class MovieController {

	@Autowired
	private MovieDAO movieDao;

	@Autowired
	private UserDAO userDao;

	@Value("${api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	MovieDtoMapper movieDtoMapper = new MovieDtoMapper();

	@Autowired
	UserMovieRatingsDAO userMovieRatingsDao;

	/*@GetMapping("/movies")
	public List<MovieDto> getUserRatedMovies(Principal principal) {
		Optional<User> user = userDao.findByName(principal.getName());
		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found - Name -" + principal.getName()));

		List<MovieDto> movieDtos = new ArrayList<MovieDto>();

		List<UserMovieRatings> userMovieRatings = userMovieRatingsDao.findByUserId(user.get().getId());

		movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
		return movieDtos;
	}*/

	@GetMapping("/movies/{movieName}")
	public List<MovieDto> getMovieSearch(@RequestParam Integer userId, @PathVariable String movieName) {
		List<MovieDto> moviesDtos = new ArrayList<MovieDto>();
		if(userId!=null) {
		Optional<User> user = userDao.findById(userId);
		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
		
		MovieSummary resp = restTemplate.getForObject(
				"https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=" + movieName,
				MovieSummary.class);
		if (!resp.getResults().isEmpty()) {
			moviesDtos = resp.getResults();
			moviesDtos.forEach(movieDto -> {
				UserMovieRatings userMovieRating = userMovieRatingsDao.findByUserIdAndMovieId(user.get().getId(),
						movieDto.getId());
				if (Objects.nonNull(userMovieRating)) {
					movieDto.setMyRating(userMovieRating.getRating());
				}
			});
		} else {
			throw new MovieNotFoundException("Movie Not Found - " + movieName);
		}
		}
		else
		{
			throw new UsernameNotFoundException("Please enter the user Id");
		}
		return moviesDtos;
	}

	@PostMapping("/movies")
	public MovieDto saveUserRatedMovies(@RequestBody MovieDto moviedto, @RequestParam Integer userId) {
		if(userId!=null)
		{
			Optional<User> user = userDao.findById(userId);
			user.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
			if(Objects.nonNull(moviedto))
			{
				User userData = new User(userId, "", "");
				Movie movieData = movieDtoMapper.getMovieFromDto(moviedto);
				movieDao.save(movieData);
				UserMovieRatings userMovieRating = new UserMovieRatings(userId, moviedto.getId(), userData, movieData,
					moviedto.getMyRating(), new Date());
				userMovieRatingsDao.save(userMovieRating);
			
			}
			else
			{
				throw new MovieNotFoundException("Movie not present");
			}
		}
		
		else
		{
			throw new UsernameNotFoundException("Please enter the user Id");
		}
		return moviedto;
	}
	/*public List<MovieDto> saveUserRatedMovies(@RequestParam Integer userId, @RequestParam Integer movieId,
			@RequestParam Double myRating) {
		Optional<User> user = userDao.findByName(principal.getName());
		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found - Name -" + principal.getName()));
		Integer userId = user.get().getId();

		if (Objects.nonNull(movieId) && Objects.nonNull(myRating)) {
			if (myRating > 0 && myRating <= 10) {
				Optional<Movie> movie = movieDao.findById(movieId);
				if (movie.isPresent()) {
					User userData = new User(userId, null, null);
					Movie movieData = new Movie(movieId, null, null, null);
					UserMovieRatings userMovieRating = new UserMovieRatings(userId, movieId, userData, movieData,
							myRating, new Date());
					userMovieRatingsDao.save(userMovieRating);
				} else {
					MovieDto movieDto = restTemplate.getForObject(
							"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieDto.class);
					if (Objects.nonNull(movieDto)) {
						User userData = new User(userId, "", "");
						Movie movieData = movieDtoMapper.getMovieFromDto(movieDto);
						movieData = movieDao.save(movieData);
						UserMovieRatings userMovieRating = new UserMovieRatings(userId, movieId, userData, movieData,
								myRating, new Date());
						userMovieRatingsDao.save(userMovieRating);
					}
				}
			} else {
				throw new RuntimeException("Rating invalid - " + myRating);
			}
		} else {
			throw new RuntimeException("Movie_Id or My_Rating not found");
		}

		List<MovieDto> movieDtos = new ArrayList<MovieDto>();
		Pageable pageable = PageRequest.of(0, 10);
		List<UserMovieRatings> userMovieRatings = userMovieRatingsDao.findByUserIdOrderByTimestampDesc(userId,
				pageable);

		movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);

		return movieDtos;
	}*/
	@GetMapping("/movies")
	public List<MovieDto> getUserMovies(@RequestParam Integer userId, 
			@RequestParam(value = "sortorder", defaultValue = "all") String sortorder,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") int size)
	{
		Optional<User> user = userDao.findById(userId);
		user.orElseThrow(() -> new UsernameNotFoundException("User Not found"));
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();
		Pageable pageable = PageRequest.of(page, size);
		if(sortorder == "time" || sortorder == "latest")
		{
			List<UserMovieRatings> userMovieRatings = userMovieRatingsDao
					.findByUserIdOrderByTimestampDesc(user.get().getId(), pageable);

			movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
			return movieDtos;
		}
		else if(sortorder == "ratings" || sortorder == "fav")
		{
			List<UserMovieRatings> userMovieRatings = userMovieRatingsDao.findByUserIdOrderByRatingDesc(user.get().getId(),
					pageable);

			movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
			return movieDtos;
		}
		else
		{
			List<UserMovieRatings> userMovieRatings = userMovieRatingsDao.findByUserId(user.get().getId(), pageable);

			movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
			return movieDtos;
		}
	}

	/*@GetMapping("/movies/TopRated")
	public List<MovieDto> getUserTopTenRatedMovies(Principal principal) {
		Optional<User> user = userDao.findByName(principal.getName());
		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found - Name -" + principal.getName()));

		List<MovieDto> movieDtos = new ArrayList<MovieDto>();

		Pageable pageable = PageRequest.of(0, 10);
		List<UserMovieRatings> userMovieRatings = userMovieRatingsDao.findByUserIdOrderByRatingDesc(user.get().getId(),
				pageable);

		movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
		return movieDtos;
	}

	@GetMapping("/movies/RecentRated")
	public List<MovieDto> getUserTenRecentlyRatedMovies(Principal principal) {
		Optional<User> user = userDao.findByName(principal.getName());
		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found - Name -" + principal.getName()));

		List<MovieDto> movieDtos = new ArrayList<MovieDto>();

		Pageable pageable = PageRequest.of(0, 10);
		List<UserMovieRatings> userMovieRatings = userMovieRatingsDao
				.findByUserIdOrderByTimestampDesc(user.get().getId(), pageable);

		movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
		return movieDtos;
	}*/
}
