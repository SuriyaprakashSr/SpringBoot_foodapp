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

import com.ty.food_app.service.ItemsService;
import com.ty.food_app.dto.Items;
import com.ty.food_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("items")
public class ItemsController {
	@Autowired
	private ItemsService service;
	
	
	@ApiOperation(value = "save Items", notes = "its used to save items ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal Server Error") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Items>> saveItems(@RequestBody Items items) {
		return service.saveItems(items);
	}
	
	@ApiOperation(value = "update Items", notes = "its used to update items ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal Server Error") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Items>> UpdateItems(@RequestBody Items items,@RequestParam int id) {
		return service.updateItems(items, id);
	}
	
	@ApiOperation(value = "get Items", notes = "its used to get items ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal Server Error") })
	@GetMapping( produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Items>>  getItems(@RequestParam int id) {
		return service.getItems(id);
	}
	
	@ApiOperation(value = "delete Items", notes = "its used to delete items ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal Server Error") })
	@DeleteMapping(produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteItems(@RequestParam int id) {
		return service.deleteItems(id);
	}
	
	
	
	


}
