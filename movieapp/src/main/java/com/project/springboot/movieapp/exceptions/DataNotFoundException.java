package com.project.springboot.movieapp.exceptions;

public class DataNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7052437320472188087L;

	public DataNotFoundException(String message) {
		super(message);
	}

}
