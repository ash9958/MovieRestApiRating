package com.project.springboot.movieapp.vo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@IdClass(UserMovieRatingspk.class)
@Entity
@Table(name = "USER_MOVIE_RATINGS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserMovieRatings {

	public UserMovieRatings(Integer userId2, Integer movieId2, User userData, Movie movieData, Double myRating,
			Date date) {
		// TODO Auto-generated constructor stub
	}

	@Id
	@JoinColumn(name = "userId")
	private Integer userId;

	@Id
	@JoinColumn(name = "movieId")
	private Integer movieId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	private User user;

	@ManyToOne(optional = false)
	@JoinColumn(name = "movieId", insertable = false, updatable = false)
	private Movie movie;

	private Double rating;

	@Column(name = "timestamp", nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	private Date timestamp;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
