package com.ty.food_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("foodorder")
public class FoodController {

	@Autowired
	FoodOrderService foodOrderService;
    
	
	@ApiOperation(value = "save foodorder", notes = "its used to save foodorde ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal Server Error") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.saveFoodOrder(foodOrder);
	}
	
	@ApiOperation(value = "get foodorder", notes = "its used to get foodorde ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal Server Error") })
	@GetMapping(produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrder(@RequestParam int id) {
		return foodOrderService.getFoodOrder(id);

	}
	
	@ApiOperation(value = "delete foodorder", notes = "its used to delete foodorde ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal Server Error") })
	@DeleteMapping( produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteFoodOrder(@RequestParam int id) {
		return foodOrderService.deleteFoodOrder(id);

	}
	
	
	@ApiOperation(value = "update foodorder", notes = "its used to update foodorde ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal Server Error") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestBody FoodOrder foodOrder,@RequestParam int id) {
		return foodOrderService.updateFoodOrder(foodOrder, id);
	}
}


