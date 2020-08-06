package com.project.springboot.movieapp.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.springboot.movieapp.vo.entity.ExceptionEntity;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> forAllUnknownException(Exception exception, WebRequest req) {
		ExceptionEntity exceptionEntity = new ExceptionEntity(exception.getMessage(), req.getDescription(false),
				new Date());
		return new ResponseEntity<Object>(exceptionEntity, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MovieNotFoundException.class)
	public final ResponseEntity<Object> movieNotFoundException(MovieNotFoundException exception, WebRequest req) {
		ExceptionEntity exceptionEntity = new ExceptionEntity();
		return new ResponseEntity<Object>(exceptionEntity, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(DataNotFoundException.class)
	public final ResponseEntity<Object> dataNotFoundException(DataNotFoundException exception, WebRequest req) {
		ExceptionEntity exceptionEntity = new ExceptionEntity(exception.getMessage(), req.getDescription(false),
				new Date());
		return new ResponseEntity<Object>(exceptionEntity, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidRequestException.class)
	public final ResponseEntity<Object> invalidRequestException(InvalidRequestException exception, WebRequest req) {
		ExceptionEntity exceptionEntity = new ExceptionEntity(exception.getMessage(), req.getDescription(false),
				new Date());
		return new ResponseEntity<Object>(exceptionEntity, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest req) {
		ExceptionEntity exceptionEntity = new ExceptionEntity(ex.getMessage(), req.getDescription(false), new Date());
		return new ResponseEntity<Object>(exceptionEntity, HttpStatus.NOT_FOUND);
	}

}
