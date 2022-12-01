package com.ty.food_app.exception;

public class NoSuchIdFoundException extends RuntimeException {

	private String message;

	public NoSuchIdFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
