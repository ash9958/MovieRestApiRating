package com.project.springboot.movieapp.controller;

import java.security.Principal;
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


import com.project.springboot.movieapp.exceptions.MovieNotFoundException;
import com.project.springboot.movieapp.service.MovieService;
import com.project.springboot.movieapp.vo.dto.MovieDto;
import com.project.springboot.movieapp.vo.dto.mapper.MovieDtoMapper;
import com.project.springboot.movieapp.vo.entity.Movie;
import com.project.springboot.movieapp.vo.entity.MovieSummary;
import com.project.springboot.movieapp.vo.entity.User;
import com.project.springboot.movieapp.vo.entity.UserMovieRatings;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	@Value("${api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	MovieDtoMapper movieDtoMapper = new MovieDtoMapper();


	@GetMapping("/movies/{movieName}")
	public List<MovieDto> getMovieSearch(Principal principal, @PathVariable String movieName) {
		List<MovieDto> moviesDtos = new ArrayList<MovieDto>();

		Optional<User> user = movieService.findByName(principal.getName());
		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

		MovieSummary resp = restTemplate.getForObject(
				"https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=" + movieName,
				MovieSummary.class);
		if (!resp.getResults().isEmpty()) {
			moviesDtos = resp.getResults();
			moviesDtos.forEach(movieDto -> {
				UserMovieRatings userMovieRating = movieService.findByUserIdAndMovieId(user.get().getId(),
						movieDto.getId());
				if (Objects.nonNull(userMovieRating)) {
					movieDto.setMyRating(userMovieRating.getRating());
				}
			});
		} else {
			throw new MovieNotFoundException("Movie Not Found - " + movieName);
		}

		return moviesDtos;
	}

	@PostMapping("/movies")
	public String saveUserRatedMovies(@RequestBody MovieDto moviedto, Principal principal) {

		Optional<User> user = movieService.findByName(principal.getName());
		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
		Integer userId = user.get().getId();

		if (Objects.nonNull(moviedto.getOverview()) && Objects.nonNull(moviedto.getTitle()) 
				&& Objects.nonNull(moviedto.getId()) && Objects.nonNull(moviedto.getMyRating())) {
			if(!moviedto.getTitle().equals("") && !moviedto.getOverview().equals("")) {
			User userData = new User(userId, "", "");
			Movie movieData = movieDtoMapper.getMovieFromDto(moviedto);
			movieService.saveMovie(movieData);
			UserMovieRatings userMovieRating = new UserMovieRatings(userId, moviedto.getId(), userData, movieData,
					moviedto.getMyRating(), new Date());
			movieService.saveRating(userMovieRating);
			}
			else
			{
				throw new MovieNotFoundException("Please enter the valid movie details");
			}
		} else {
			throw new MovieNotFoundException("Movie not present");
		}

		return "Movie saved successfully";
	}

	@GetMapping("/movies")
	public List<MovieDto> getUserMovies(Principal principal, @RequestParam(defaultValue = "all") String sortorder,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		Optional<User> user = movieService.findByName(principal.getName());
		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

		List<MovieDto> movieDtos = new ArrayList<MovieDto>();
		Pageable pageable = PageRequest.of(page, size);
		if (sortorder.equalsIgnoreCase("time") || sortorder.equalsIgnoreCase("latest")) {
			List<UserMovieRatings> userMovieRatings = movieService
					.findByUserIdOrderByTimestampDesc(user.get().getId(), pageable);

			movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
		} else if (sortorder.equalsIgnoreCase("ratings") || sortorder.equalsIgnoreCase("fav")) {
			List<UserMovieRatings> userMovieRatings = movieService
					.findByUserIdOrderByRatingDesc(user.get().getId(), pageable);

			movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
		
		} else if (sortorder.equalsIgnoreCase("all")) {
			List<UserMovieRatings> userMovieRatings = movieService.findByUserId(user.get().getId(), pageable);

			movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
	
		} else {
			throw new MovieNotFoundException("Invalid sorting order");
		}
		return movieDtos;
	}
}
