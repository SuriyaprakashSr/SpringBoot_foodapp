package com.ty.food_app.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.food_app.exception.NoSuchIdFoundException;
import com.ty.food_app.dao.ProductDao;
import com.ty.food_app.dto.Items;
import com.ty.food_app.dto.Product;
import com.ty.food_app.util.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	ProductDao dao;

	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product, int id) {
		Product product1 = dao.getProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Product>> responseEntity = new ResponseEntity<ResponseStructure<Product>>(
				responseStructure, HttpStatus.OK);

		if (product1 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(dao.updateProduct(product));
		} else {
			throw new NoSuchIdFoundException("no such id found");
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Product>> getPoduct(int id) {
		Product product = dao.getProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Product>> responseEntity = new ResponseEntity<ResponseStructure<Product>>(
				responseStructure, HttpStatus.OK);

		if (product != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("received");
			responseStructure.setData(dao.getProductById(id));
		} else {
			throw new NoSuchIdFoundException("no such id found");
		}
		return responseEntity;
	}

}
