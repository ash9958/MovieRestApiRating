package com.project.springboot.movieapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movie {
	
	@Id
	private Integer id;
	private String title;
	private Double averageRating;
	@Lob
	private String overview;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public Movie()
	{
		
	}
	public Movie(Integer id, String title, Double averageRating, String overview) {
		super();
		this.id = id;
		this.title = title;
		this.averageRating = averageRating;
		this.overview = overview;
	}
	
}
