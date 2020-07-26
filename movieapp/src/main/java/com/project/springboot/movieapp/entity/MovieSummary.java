package com.project.springboot.movieapp.entity;

import java.util.List;

public class MovieSummary {

    
    private List<MovieDto> results;

	public List<MovieDto> getResults() {
		return results;
	}

	public void setResults(List<MovieDto> results) {
		this.results = results;
	}
	public MovieSummary()
	{
		
	}
}