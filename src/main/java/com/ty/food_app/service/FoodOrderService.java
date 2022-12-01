package com.ty.food_app.service;

import java.util.Iterator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.food_app.dao.FoodOrderDao;
import com.ty.food_app.dto.FoodOrder;
import com.ty.food_app.dto.Items;
import com.ty.food_app.dto.Menu;
import com.ty.food_app.dto.Product;
import com.ty.food_app.exception.NoSuchIdFoundException;
import com.ty.food_app.util.ResponseStructure;

@Service
public class FoodOrderService {

	@Autowired
	private FoodOrderDao dao;

	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {
		List<Product> products = foodOrder.getProducts();
		double totalCost = 0;
		for (Product product : products) {
			totalCost = totalCost + (product.getPrice() * product.getQty());
		}
		totalCost = (totalCost * 0.18) + totalCost;
		foodOrder.setTotalCost(totalCost);

		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<FoodOrder>> responseEntity = new ResponseEntity<ResponseStructure<FoodOrder>>(
				responseStructure, HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveFoodOrder(foodOrder));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(FoodOrder foodOrder, int id) {
		FoodOrder foodOrder2 = dao.getFoodOrderById(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<FoodOrder>> responseEntity = new ResponseEntity<ResponseStructure<FoodOrder>>(
				responseStructure, HttpStatus.CREATED);

		if (foodOrder2 != null) {
			foodOrder.setId(id);
			List<Product> products = foodOrder.getProducts();
			double totalCost = 0;
			for (Product product : products) {
				totalCost = totalCost + (product.getPrice() * product.getQty());
			}
			totalCost = (totalCost * 0.18) + totalCost;
			foodOrder.setTotalCost(totalCost);

			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(dao.saveFoodOrder(foodOrder));
		} else {

			throw new NoSuchIdFoundException("cannot get no id found");

		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrder(int id) {
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<FoodOrder>> responseEntity = new ResponseEntity<ResponseStructure<FoodOrder>>(
				responseStructure, HttpStatus.OK);

		FoodOrder foodOrder = dao.getFoodOrderById(id);

		if (foodOrder != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("received");
			responseStructure.setData(dao.getFoodOrderById(id));
		} else {
			throw new NoSuchIdFoundException("cannot get no id found");
		}
		return responseEntity;

	}

	public ResponseEntity<ResponseStructure<String>> deleteFoodOrder(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
				responseStructure, HttpStatus.OK);

		FoodOrder foodOrder = dao.getFoodOrderById(id);
		if (foodOrder != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(dao.deleteFoodOrderById(id));
		} else {
			throw new NoSuchIdFoundException("cannot get no id found");
		}
		return responseEntity;

	}

}
