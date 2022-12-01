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

import com.ty.food_app.service.FoodOrderService;
import com.ty.food_app.dto.FoodOrder;
import com.ty.food_app.util.ResponseStructure;

@RestController
@RequestMapping("foodorder")
public class FoodController {

	@Autowired
	FoodOrderService foodOrderService;

	@PostMapping
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.saveFoodOrder(foodOrder);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrder(@RequestParam int id) {
		return foodOrderService.getFoodOrder(id);

	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteFoodOrder(@RequestParam int id) {
		return foodOrderService.deleteFoodOrder(id);

	}
	
	
	@PutMapping
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestBody FoodOrder foodOrder,@RequestParam int id) {
		return foodOrderService.updateFoodOrder(foodOrder, id);
	}
}


