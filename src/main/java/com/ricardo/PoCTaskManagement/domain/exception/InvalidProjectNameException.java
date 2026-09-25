package com.ricardo.PoCTaskManagement.domain.exception;

public class InvalidProjectNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidProjectNameException(String message) {
		super(message);
	}
}
