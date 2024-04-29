package com.exception;

public class FileHandlingException extends Exception {
	private String message; 
	
	public FileHandlingException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
