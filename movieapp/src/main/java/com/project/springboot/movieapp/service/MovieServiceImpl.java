package com.project.springboot.movieapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.springboot.movieapp.dao.MovieDAO;
import com.project.springboot.movieapp.dao.UserMovieRatingsDAO;
import com.project.springboot.movieapp.exceptions.DataNotFoundException;
import com.project.springboot.movieapp.exceptions.InvalidRequestException;
import com.project.springboot.movieapp.exceptions.MovieNotFoundException;
import com.project.springboot.movieapp.vo.dto.MovieDto;
import com.project.springboot.movieapp.vo.dto.MovieSummary;
import com.project.springboot.movieapp.vo.dto.mapper.MovieDtoMapper;
import com.project.springboot.movieapp.vo.entity.Movie;
import com.project.springboot.movieapp.vo.entity.User;
import com.project.springboot.movieapp.vo.entity.UserMovieRatings;
import com.project.springboot.movieapp.vo.entity.UserMovieRatingspk;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDAO movieDao;

	@Autowired
	UserMovieRatingsDAO userMovieRatingsDao;

	@Value("${api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	MovieDtoMapper movieDtoMapper = new MovieDtoMapper();

	@Override
	public List<MovieDto> getMovie(String movieTitle, Integer id) {
		List<MovieDto> moviesDtos = new ArrayList<MovieDto>();
		MovieSummary resp = restTemplate.getForObject(
				"https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=" + movieTitle,
				MovieSummary.class);
		if (!resp.getResults().isEmpty()) {
			moviesDtos = resp.getResults();
			moviesDtos.forEach(movieDto -> {
				UserMovieRatings userMovieRating = userMovieRatingsDao
						.findByUserMovieRatingspk_User_IdAndUserMovieRatingspk_Movie_Id(id, movieDto.getId());
				if (Objects.nonNull(userMovieRating)) {
					movieDto.setMyRating(userMovieRating.getRating());
				}
			});
		} else {
			throw new MovieNotFoundException();
		}
		return moviesDtos;
	}

	@Override
	public void saveMovie(MovieDto moviedto, Integer userId) {

		Integer movieId = moviedto.getId();
		Double myRating = moviedto.getMyRating();
		MovieDto movieDtoResult = new MovieDto();
		if (Objects.nonNull(movieId) && Objects.nonNull(myRating)) {
			if (myRating > 0 && myRating <= 10) {
				Optional<Movie> movie = movieDao.findById(movieId);

				if (movie.isPresent()) {
					User userData = new User(userId, null, null);
					UserMovieRatingspk userMovieRatingspk = new UserMovieRatingspk(userData, movie.get());
					UserMovieRatings userMovieRating = new UserMovieRatings(userMovieRatingspk, moviedto.getMyRating(),
							new Date());
					userMovieRatingsDao.save(userMovieRating);

				} else {
					try {
						movieDtoResult = restTemplate.getForObject(
								"https://api.themoviedb.org/3/movie/" + moviedto.getId() + "?api_key=" + apiKey,
								MovieDto.class);
					} catch (Exception e) {
						throw new DataNotFoundException("Movie not found for movieId: " + movieId);
					}
					if (Objects.nonNull(movieDtoResult)) {
						User userData = new User(userId, "", "");
						Movie movieData = movieDtoMapper.getMovieFromDto(movieDtoResult);
						movieData = movieDao.save(movieData);
						UserMovieRatingspk userMovieRatingspk = new UserMovieRatingspk(userData, movieData);
						UserMovieRatings userMovieRating = new UserMovieRatings(userMovieRatingspk,
								moviedto.getMyRating(), new Date());
						userMovieRatingsDao.save(userMovieRating);
					}

				}

			} else {
				throw new InvalidRequestException("Invalid Rating: " + myRating);
			}
		} else {
			throw new DataNotFoundException("MovieId or Rating not Found");
		}
	}

	@Override
	public List<MovieDto> getMovieList(Integer userId, Pageable pageable) {
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();

		List<UserMovieRatings> userMovieRatings = userMovieRatingsDao.findByUserMovieRatingspk_User_Id(userId,
				pageable);

		movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
		if (Objects.isNull(movieDtos)) {
			throw new MovieNotFoundException();
		}
		return movieDtos;
	}

}
