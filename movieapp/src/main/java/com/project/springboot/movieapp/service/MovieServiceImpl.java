package com.project.springboot.movieapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.springboot.movieapp.dao.MovieDAO;
import com.project.springboot.movieapp.dao.UserDAO;
import com.project.springboot.movieapp.dao.UserMovieRatingsDAO;
import com.project.springboot.movieapp.vo.entity.Movie;
import com.project.springboot.movieapp.vo.entity.User;
import com.project.springboot.movieapp.vo.entity.UserMovieRatings;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDAO movieDao;

	@Autowired
	private UserDAO userDao;

	@Autowired
	UserMovieRatingsDAO userMovieRatingsDao;

	@Override
	public UserMovieRatings findByUserIdAndMovieId(Integer userId, Integer id) {

		return userMovieRatingsDao.findByUserIdAndMovieId(userId, id);
	}

	@Override
	public List<UserMovieRatings> findByUserIdOrderByTimestampDesc(Integer userId, Pageable pageable) {

		return userMovieRatingsDao.findByUserIdOrderByTimestampDesc(userId, pageable);
	}

	@Override
	public List<UserMovieRatings> findByUserId(Integer userId, Pageable pageable) {

		return userMovieRatingsDao.findByUserId(userId, pageable);
	}

	@Override
	public List<UserMovieRatings> findByUserIdOrderByRatingDesc(Integer userId, Pageable pageable) {

		return userMovieRatingsDao.findByUserIdOrderByRatingDesc(userId, pageable);
	}

	@Override
	public Movie findAllById(Integer id) {

		return movieDao.findAllById(id);
	}

	@Override
	public Optional<User> findByName(String name) {

		return userDao.findByName(name);
	}

	@Override
	public void saveMovie(Movie movie) {

		movieDao.save(movie);

	}

	@Override
	public void saveRating(UserMovieRatings userMovieRating) {
		
		userMovieRatingsDao.save(userMovieRating);	
	}

}
