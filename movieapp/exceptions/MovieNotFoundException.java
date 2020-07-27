package com.project.springboot.movieapp.exceptions;

public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2501229274022220879L;


	public MovieNotFoundException(String message) {
		super(message);
	}
}
