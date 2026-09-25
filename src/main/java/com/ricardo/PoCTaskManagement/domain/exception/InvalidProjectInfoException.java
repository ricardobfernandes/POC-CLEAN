package com.ricardo.PoCTaskManagement.domain.exception;

public class InvalidProjectInfoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidProjectInfoException(String message) {
		super(message);
	}
}