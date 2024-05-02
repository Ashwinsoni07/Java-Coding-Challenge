package com.exception;

public class PolicyNotFoundException extends Exception {
	private String message;

	public String getMessage() {
		return message;
	}

	public PolicyNotFoundException(String message) {
		this.message = message;
	}
}
