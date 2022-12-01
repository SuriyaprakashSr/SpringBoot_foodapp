package com.ty.food_app.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.food_app.service.ProductService;
import com.ty.food_app.dto.Items;
import com.ty.food_app.dto.Product;
import com.ty.food_app.util.ResponseStructure;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Product>>  getProduct(@RequestParam int id) {
		return service.getPoduct(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Product>>  getProduct(@RequestBody Product product,@RequestParam int id) {
		return service.updateProduct(product, id);
	}
	
	

}
