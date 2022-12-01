package com.ty.food_app.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.food_app.service.UserService;
import com.ty.food_app.dto.User;
import com.ty.food_app.util.ResponseStructure;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {

		return service.saveUser(user);

	}
	

	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user,@RequestParam int id) {

		return service.updateUser(user, id);

	}
	
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteUserById(@RequestParam int id){
		return service.deleteUserById(id);
	}
	
	
	@GetMapping
    public ResponseEntity<ResponseStructure<User>> getUserByid(@RequestParam int id){
    	return service.getUserById(id);
    }
}
