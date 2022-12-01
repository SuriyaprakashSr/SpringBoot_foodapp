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

import com.ty.food_app.service.MenuServices;
import com.ty.food_app.dto.Menu;
import com.ty.food_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("menu")
public class MenuController {
	
	@Autowired
	private MenuServices menuServices;
	
	
	@ApiOperation(value = "save menu", notes = "its used to save menu ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal Server Error") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Menu>>  saveMenu(@RequestBody Menu menu){
		return menuServices.saveMenu(menu);
	}
	
	@ApiOperation(value = "update menu", notes = "its used to update menu")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal Server Error") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Menu>>  updateMenu(@RequestBody Menu menu,@RequestParam int id){
		return menuServices.updateMenu(menu, id);
	}
	
	@ApiOperation(value = "get menu", notes = "its used to get menu")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal Server Error") })
	@GetMapping( produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int id){
		return menuServices.getMenuById(id);
	}
	
	@ApiOperation(value = "delete menu", notes = "its used to delete menu")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal Server Error") })
	@DeleteMapping( produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteMenuById(int id){
		return menuServices.deleteMenuById(id);
	}

		
	
	
	
	

}
