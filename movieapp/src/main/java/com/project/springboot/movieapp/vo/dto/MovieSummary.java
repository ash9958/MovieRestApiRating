package com.project.springboot.movieapp.vo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieSummary {    
    private List<MovieDto> results;

	public List<MovieDto> getResults() {
		return results;
	}

	public void setResults(List<MovieDto> results) {
		this.results = results;
	}
}