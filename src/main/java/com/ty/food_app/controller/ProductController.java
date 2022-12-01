package com.ty.food_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService service;

	@ApiOperation(value = "get Prodeuct", notes = "its used to get product")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal Server Error") })
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Product>> getProduct(@RequestParam int id) {
		return service.getPoduct(id);
	}

	@ApiOperation(value = "update user", notes = "its used to update user")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal Server Error") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product,
			@RequestParam int id) {
		return service.updateProduct(product, id);
	}

}
