package com.ty.food_app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.food_app.repository.ItemsRepository;
import com.ty.food_app.dto.Items;
import com.ty.food_app.dto.Menu;

@Repository
public class ItemsDao {

	@Autowired
	private ItemsRepository repository;

	public Items saveItems(Items items) {
		return repository.save(items);
	}

	public Items updateItems(Items items) {
		return repository.save(items);
	}

	public Items getItemsById(int id) {
		Optional<Items> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;

	}

	public String deleteItemsById(int id) {
		repository.deleteById(id);
		return "deleted";
	}

}
