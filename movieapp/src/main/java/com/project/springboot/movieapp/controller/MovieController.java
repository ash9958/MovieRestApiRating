package com.project.springboot.movieapp.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.movieapp.dao.UserDAO;
import com.project.springboot.movieapp.exceptions.InvalidRequestException;
import com.project.springboot.movieapp.exceptions.DataNotFoundException;
import com.project.springboot.movieapp.service.MovieService;
import com.project.springboot.movieapp.vo.dto.MovieDto;
import com.project.springboot.movieapp.vo.dto.mapper.MovieDtoMapper;
import com.project.springboot.movieapp.vo.entity.User;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private UserDAO userDao;

	MovieDtoMapper movieDtoMapper = new MovieDtoMapper();

	@GetMapping("/searchmovies")
	public List<MovieDto> getMovieSearch(Principal principal, @RequestParam Optional<String> movieTitle) {
		List<MovieDto> moviesDtos = new ArrayList<MovieDto>();

		Optional<User> user = userDao.findByName(principal.getName());
		user.orElseThrow(() -> new UsernameNotFoundException("User not found"));

		movieTitle.orElseThrow(() -> new InvalidRequestException("Parameter 'movieTitle' required"));

		if (movieTitle.get().equals("")) {
			throw new DataNotFoundException("Movie Title not found");
		} else {
			moviesDtos = movieService.getMovie(movieTitle.get(), user.get().getId());
		}

		return moviesDtos;
	}

	@PostMapping("/movies")
	public String saveUserRatedMovies(@RequestBody MovieDto moviedto, Principal principal) {

		Optional<User> user = userDao.findByName(principal.getName());
		user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		movieService.saveMovie(moviedto, user.get().getId());

		return "Movie saved successfully";
	}

	@GetMapping("/movies")
	public List<MovieDto> getUserMovies(Principal principal,
			@RequestParam(value = "sort", defaultValue = "userMovieRatingspk") String sort,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		Optional<User> user = userDao.findByName(principal.getName());
		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

		List<MovieDto> movieDtos = new ArrayList<MovieDto>();
		Pageable pageable = PageRequest.of(page, size, Sort.by(Direction.DESC, sort));
		movieDtos = movieService.getMovieList(user.get().getId(), pageable);

		return movieDtos;
	}
}
