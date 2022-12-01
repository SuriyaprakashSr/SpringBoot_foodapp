package com.ty.food_app.dao;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.food_app.repository.UserRepository;
import com.ty.food_app.dto.User;

@Repository
public class Userdao {

	@Autowired
	private UserRepository repository;

	public User saveUser(User user) {
		return repository.save(user);
	}

	public User updateUser(User user) {
		return repository.save(user);
	}

	public User getUserById(int id) {
		Optional<User> optional = repository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();

	}

	public String deleteUserById(int id) {
		repository.deleteById(id);
		return "deleted";
	}

}
