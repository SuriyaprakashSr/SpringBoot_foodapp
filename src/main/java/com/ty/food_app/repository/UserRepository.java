package com.ty.food_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.food_app.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
