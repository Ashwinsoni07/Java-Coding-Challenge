package com.exception;

	public class InvalidCredentialException extends Exception {
		private String message;

		public String getMessage() {
			return message;
		}

		public InvalidCredentialException(String message) {
			this.message = message;
		}
	

}
