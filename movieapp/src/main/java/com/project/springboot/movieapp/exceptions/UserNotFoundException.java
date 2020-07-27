package com.project.springboot.movieapp.exceptions;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7948042657639288426L;

	/**
	 * @param message
	 */
	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
