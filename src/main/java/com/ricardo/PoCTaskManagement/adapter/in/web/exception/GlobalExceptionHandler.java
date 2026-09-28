package com.ricardo.PoCTaskManagement.adapter.in.web.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ricardo.PoCTaskManagement.domain.exception.InvalidProjectInfoException;
import com.ricardo.PoCTaskManagement.domain.exception.InvalidTaskException;
import com.ricardo.PoCTaskManagement.domain.exception.InvalidUserInfoException;
import com.ricardo.PoCTaskManagement.domain.exception.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> handleNotFound(ResourceNotFoundException exception) {
		return buildError(HttpStatus.NOT_FOUND, exception.getMessage());
	}

	@ExceptionHandler({ InvalidTaskException.class, InvalidProjectInfoException.class, InvalidUserInfoException.class })
	public ResponseEntity<StandardError> handleBadRequest(RuntimeException exception) {
		return buildError(HttpStatus.BAD_REQUEST, exception.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> handleValidation(MethodArgumentNotValidException exception) {

		String message = exception.getBindingResult().getFieldErrors().stream().findFirst().map(error -> error.getField() + ": " + error.getDefaultMessage()).orElse("Invalid request");
		return buildError(HttpStatus.BAD_REQUEST, message);
	}

	private ResponseEntity<StandardError> buildError(HttpStatus status, String message) {

		StandardError error = new StandardError(Instant.now(), status.value(), status.getReasonPhrase(), message);
		return ResponseEntity.status(status).body(error);
	}
}