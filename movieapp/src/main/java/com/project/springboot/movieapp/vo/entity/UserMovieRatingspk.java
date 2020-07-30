package com.project.springboot.movieapp.vo.entity;

import java.io.Serializable;

import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserMovieRatingspk implements Serializable {

	private static final long serialVersionUID = -1271609949196573132L;
	
	@MapsId("id")
	@ManyToOne
	private User user;

	@MapsId("id")
	@ManyToOne
	private Movie movie;
}
