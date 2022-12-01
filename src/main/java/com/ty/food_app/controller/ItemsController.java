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

import com.ty.food_app.service.ItemsService;
import com.ty.food_app.dto.Items;
import com.ty.food_app.util.ResponseStructure;

@RestController
@RequestMapping("items")
public class ItemsController {
	@Autowired
	private ItemsService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Items>> saveItems(@RequestBody Items items) {
		return service.saveItems(items);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Items>> UpdateItems(@RequestBody Items items,@RequestParam int id) {
		return service.updateItems(items, id);
	}
	
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Items>>  getItems(@RequestParam int id) {
		return service.getItems(id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteItems(@RequestParam int id) {
		return service.deleteItems(id);
	}
	
	
	
	


}
