package com.ty.food_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.food_app.dto.User;
import com.ty.food_app.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptonHandler {
	
	
	@ExceptionHandler(NoSuchIdFoundException.class)
	public ResponseEntity<ResponseStructure<User>> noSuchIdFoundHandler(NoSuchIdFoundException exception){
		ResponseStructure responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.NOT_FOUND);
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("no id found");
		responseStructure.setData(exception.getMessage());
		return responseEntity;
	}

	
	@ExceptionHandler(UnableToUpdateUserException.class)
	public ResponseEntity<ResponseStructure<User>> unableToUpdateUserHandler(UnableToUpdateUserException exception){
		ResponseStructure responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.NOT_FOUND);
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("no id found");
		responseStructure.setData(exception.getMessage());
		return responseEntity;
	}
	
	
	
	
	
}
