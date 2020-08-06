package com.project.springboot.movieapp.exceptions;

public class InvalidRequestException extends RuntimeException {

	private static final long serialVersionUID = -3217939741446963282L;

	public InvalidRequestException(String message) {
		super(message);
	}
}
