package com.project.springboot.movieapp.exceptions;

public class NoRelatedDataException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7052437320472188087L;

	public NoRelatedDataException(String message) {
		super(message);
	}

}
