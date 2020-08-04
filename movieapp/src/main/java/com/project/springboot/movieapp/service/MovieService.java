package com.project.springboot.movieapp.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.project.springboot.movieapp.vo.dto.MovieDto;


public interface MovieService {

	public List<MovieDto> getMovie(String movieName, Integer id);

	public void saveMovie(MovieDto moviedto, Integer userId);

	public List<MovieDto> getMovieList(Integer userId, Pageable pageable);
}
