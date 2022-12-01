package com.ty.food_app.dao;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.food_app.repository.ProductRepository;
import com.ty.food_app.dto.Product;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public Product updateProduct(Product product) {
		return repository.save(product);
	}

	public Product getProductById(int id) {
		Optional<Product> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public String deleteStringById(int id) {
		repository.deleteById(id);
		return "deleted";
	}

}
