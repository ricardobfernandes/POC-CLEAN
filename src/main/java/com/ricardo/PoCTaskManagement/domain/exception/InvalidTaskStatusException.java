package com.ricardo.PoCTaskManagement.domain.exception;

public class InvalidTaskStatusException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidTaskStatusException(String message) {
		super(message);
	}
}
