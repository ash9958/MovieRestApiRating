package com.project.springboot.movieapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.project.springboot.movieapp.vo.entity.Movie;
import com.project.springboot.movieapp.vo.entity.User;
import com.project.springboot.movieapp.vo.entity.UserMovieRatings;

public interface MovieService {
	
	UserMovieRatings findByUserIdAndMovieId(Integer userId, Integer id);

	List<UserMovieRatings> findByUserIdOrderByTimestampDesc(Integer userId, Pageable pageable);

	List<UserMovieRatings> findByUserId(Integer userId, Pageable pageable);

	List<UserMovieRatings> findByUserIdOrderByRatingDesc(Integer userId, Pageable pageable);
	
	Movie findAllById(Integer id);
	
	public Optional<User> findByName(String name);
	
	public void saveMovie(Movie movie);
	
	public void saveRating(UserMovieRatings userMovieRating);
}
