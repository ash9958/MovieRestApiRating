package com.project.springboot.movieapp.exception;

import java.util.Date;

public class ExceptionEntity {
	private String message;
	private String details;
	private Date timestamp;
	
	public ExceptionEntity()
	{
		  
	}

	
	


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}