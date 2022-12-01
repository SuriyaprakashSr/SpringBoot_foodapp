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

import com.ty.food_app.service.MenuServices;
import com.ty.food_app.dto.Menu;
import com.ty.food_app.util.ResponseStructure;

@RestController
@RequestMapping("menu")
public class MenuController {
	
	@Autowired
	private MenuServices menuServices;
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Menu>>  saveMenu(@RequestBody Menu menu){
		return menuServices.saveMenu(menu);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Menu>>  updateMenu(@RequestBody Menu menu,@RequestParam int id){
		return menuServices.updateMenu(menu, id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int id){
		return menuServices.getMenuById(id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteMenuById(int id){
		return menuServices.deleteMenuById(id);
	}

		
	
	
	
	

}
