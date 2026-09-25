package com.ricardo.PoCTaskManagement.domain.exception;

public class InvalidUserInfoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidUserInfoException(String message) {
		super(message);
	}
}
