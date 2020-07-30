package com.project.springboot.movieapp.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.movieapp.vo.entity.UserMovieRatings;
import com.project.springboot.movieapp.vo.entity.UserMovieRatingspk;

public interface UserMovieRatingsDAO extends JpaRepository<UserMovieRatings, UserMovieRatingspk> {

	UserMovieRatings findByUserMovieRatingspk_User_IdAndUserMovieRatingspk_Movie_Id(Integer id, Integer id2);

	List<UserMovieRatings> findByUserMovieRatingspk_User_IdOrderByTimestampDesc(Integer id, Pageable pageable);

	List<UserMovieRatings> findByUserMovieRatingspk_User_IdOrderByRatingDesc(Integer id, Pageable pageable);

	List<UserMovieRatings> findByUserMovieRatingspk_User_Id(Integer id, Pageable pageable);

}

