package com.project.springboot.movieapp.vo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER_MOVIE_RATINGS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserMovieRatings {
	
	@EmbeddedId
	UserMovieRatingspk userMovieRatingspk;

	private Double rating;

	@Column(name = "timestamp", nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	private Date timestamp;

}
