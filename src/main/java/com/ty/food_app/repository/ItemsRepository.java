package com.ty.food_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.food_app.dto.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
