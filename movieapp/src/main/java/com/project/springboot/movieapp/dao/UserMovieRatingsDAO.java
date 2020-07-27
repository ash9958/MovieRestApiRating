package com.project.springboot.movieapp.dao;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.movieapp.vo.entity.UserMovieRatings;
import com.project.springboot.movieapp.vo.entity.UserMovieRatingspk;

public interface UserMovieRatingsDAO extends JpaRepository<UserMovieRatings, UserMovieRatingspk> {
	UserMovieRatings findByUserIdAndMovieId(Integer userId, Integer id);

	List<UserMovieRatings> findByUserIdOrderByTimestampDesc(Integer userId, Pageable pageable);

	List<UserMovieRatings> findByUserId(Integer userId);

	List<UserMovieRatings> findByUserIdOrderByRatingDesc(Integer userId, Pageable pageable);

}

