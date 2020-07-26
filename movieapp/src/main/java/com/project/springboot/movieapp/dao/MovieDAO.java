package com.project.springboot.movieapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.movieapp.entity.Movie;

public interface MovieDAO extends JpaRepository<Movie, Integer> {

	Movie findAllById(Integer id);
}
