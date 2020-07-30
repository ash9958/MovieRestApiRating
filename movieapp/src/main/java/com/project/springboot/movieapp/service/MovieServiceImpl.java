package com.project.springboot.movieapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.springboot.movieapp.vo.entity.Movie;
import com.project.springboot.movieapp.vo.entity.User;
import com.project.springboot.movieapp.vo.entity.UserMovieRatings;

@Service
public class MovieServiceImpl implements MovieService {

	@Override
	public UserMovieRatings findByUserIdAndMovieId(Integer userId, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserMovieRatings> findByUserIdOrderByTimestampDesc(Integer userId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserMovieRatings> findByUserId(Integer userId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserMovieRatings> findByUserIdOrderByRatingDesc(Integer userId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie findAllById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveRating(UserMovieRatings userMovieRating) {
		// TODO Auto-generated method stub
		
	}

//	@Autowired
//	private MovieDAO movieDao;
//
//	@Autowired
//	private UserDAO userDao;
//
//	@Autowired
//	UserMovieRatingsDAO userMovieRatingsDao;
//
//	@Override
//	public UserMovieRatings findByUserIdAndMovieId(Integer userId, Integer id) {
//
//		return userMovieRatingsDao.findByUserIdAndMovieId(userId, id);
//	}
//
//	@Override
//	public List<UserMovieRatings> findByUserIdOrderByTimestampDesc(Integer userId, Pageable pageable) {
//
//		return userMovieRatingsDao.findByUserIdOrderByTimestampDesc(userId, pageable);
//	}
//
//	@Override
//	public List<UserMovieRatings> findByUserId(Integer userId, Pageable pageable) {
//
//		return userMovieRatingsDao.findByUserId(userId, pageable);
//	}
//
//	@Override
//	public List<UserMovieRatings> findByUserIdOrderByRatingDesc(Integer userId, Pageable pageable) {
//
//		return userMovieRatingsDao.findByUserIdOrderByRatingDesc(userId, pageable);
//	}
//
//	@Override
//	public Movie findAllById(Integer id) {
//
//		return movieDao.findAllById(id);
//	}
//
//	@Override
//	public Optional<User> findByName(String name) {
//
//		return userDao.findByName(name);
//	}
//
//	@Override
//	public void saveMovie(Movie movie) {
//
//		movieDao.save(movie);
//
//	}
//
//	@Override
//	public void saveRating(UserMovieRatings userMovieRating) {
//		
//		userMovieRatingsDao.save(userMovieRating);	
//	}

}
