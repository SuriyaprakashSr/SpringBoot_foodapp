package com.ty.food_app.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.food_app.dao.ItemsDao;
import com.ty.food_app.dto.Items;
import com.ty.food_app.dto.Menu;
import com.ty.food_app.exception.NoSuchIdFoundException;
import com.ty.food_app.util.ResponseStructure;

@Service
public class ItemsService {

	@Autowired
	private ItemsDao dao;

	public ResponseEntity<ResponseStructure<Items>> saveItems(Items items) {
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Items>> responseEntity = new ResponseEntity<ResponseStructure<Items>>(
				responseStructure, HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveItems(items));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Items>> updateItems(Items items, int id) {
		Items items2 = dao.getItemsById(id);
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Items>> responseEntity = new ResponseEntity<ResponseStructure<Items>>(
				responseStructure, HttpStatus.OK);

		if (items2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(dao.updateItems(items));
		} else {
			throw new NoSuchIdFoundException("no such id found");
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<String>> deleteItems(int id) {
		Items items2 = dao.getItemsById(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
				responseStructure, HttpStatus.CREATED);

		if (items2 != null) {
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(dao.deleteItemsById(id));
		} else {
			throw new NoSuchIdFoundException("no such id found");
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Items>> getItems(int id) {
		Items items2 = dao.getItemsById(id);
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Items>> responseEntity = new ResponseEntity<ResponseStructure<Items>>(
				responseStructure, HttpStatus.OK);

		if (items2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("received");
			responseStructure.setData(dao.getItemsById(id));
		} else {
			throw new NoSuchIdFoundException("no such id found");
		}
		return responseEntity;
	}

}
