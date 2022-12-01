package com.ty.food_app.exception;

public class UnableToUpdateUserException  extends RuntimeException{
	
	private String message;
	
	
	public UnableToUpdateUserException(String message) {
		this.message=message;
	}


	@Override
	public String getMessage() {
		
		return message;
	}
	
	
	

}
