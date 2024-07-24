package com.fitnessarea.exception;

public class ResourceNotFoundException extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResourceNotFoundException [message=" + message + "]";
	}

	public ResourceNotFoundException() {
		super();
	}
	
	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
	}

	
	
}
