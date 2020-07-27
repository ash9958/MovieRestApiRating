package com.project.springboot.movieapp.vo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	
	@Id
	private Integer id;
	private String title;
	private Double averageRating;
	@Lob
	private String overview;
}
