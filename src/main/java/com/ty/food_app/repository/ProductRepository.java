package com.ty.food_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.food_app.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
