package com.ty.food_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.food_app.exception.NoSuchIdFoundException;
import com.ty.food_app.exception.UnableToUpdateUserException;
import com.ty.food_app.dao.Userdao;
import com.ty.food_app.dto.User;
import com.ty.food_app.util.ResponseStructure;


@Service
public class UserService {
	
	@Autowired
	private Userdao dao;
	
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user){
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveUser(user));
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);

		return responseEntity;
	}
	
	public  ResponseEntity<ResponseStructure<User>> updateUser(User user,int id){
		User user2 = dao.getUserById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);

		if(user2!=null) {
	    user.setId(id);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.updateUser(user));
		}
		else {
			throw  new UnableToUpdateUserException("unable to update Because id not found");
		}
		return responseEntity;
	}
	
	
	public ResponseEntity<ResponseStructure<User>> getUserById(int id){
		User user = dao.getUserById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);

		if(user!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("received");
		responseStructure.setData(dao.getUserById(id));
		}
		else {
			throw new NoSuchIdFoundException("Id Not Found");
		}
		
		return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteUserById(int id){
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);

		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("deleted");
		responseStructure.setData(dao.deleteUserById(id));
		return responseEntity;
	}
	
}
