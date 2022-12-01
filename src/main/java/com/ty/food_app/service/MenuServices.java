package com.ty.food_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ty.food_app.exception.NoSuchIdFoundException;
import com.ty.food_app.exception.UnableToUpdateUserException;
import com.ty.food_app.dao.MenuDao;
import com.ty.food_app.dto.Menu;
import com.ty.food_app.dto.User;
import com.ty.food_app.util.ResponseStructure;

@Service
public class MenuServices {
	@Autowired
	MenuDao dao;

	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Menu>> responseEntity = new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveMenu(menu));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Menu>> updateMenu(Menu menu, int id) {
		Menu menu2 = dao.getMenuById(id);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Menu>> responseEntity = new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.CREATED);
		if (menu2 != null) {
			menu.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("saved");
			responseStructure.setData(dao.updateMenu(menu));
		} else {
			throw new UnableToUpdateUserException("cannot update no id found");
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int id) {
		Menu menu2 = dao.getMenuById(id);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Menu>> responseEntity = new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);

		if (menu2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("saved");
			responseStructure.setData(dao.getMenuById(id));
		} else {
			throw new NoSuchIdFoundException("cannot get no id found");
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<String>> deleteMenuById(int id) {
		Menu menu2 = dao.getMenuById(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);

		if (menu2 != null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("deleted");
		responseStructure.setData(dao.deleteMenuById(id));
		}else {
			throw new NoSuchIdFoundException("cannot get no id found");
	
		}
		return responseEntity;
	}

}
