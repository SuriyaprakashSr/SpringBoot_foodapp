package com.ty.food_app.dao;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.food_app.repository.FoodOrderRepository;
import com.ty.food_app.dto.FoodOrder;

@Repository
public class FoodOrderDao {

	@Autowired
	private FoodOrderRepository repository;
	
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return repository.save(foodOrder);
	}
	
	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
		return repository.save(foodOrder);
	}
	
	public FoodOrder   getFoodOrderById(int id) {
		Optional<FoodOrder> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public String  deleteFoodOrderById(int id) {
       repository.deleteById(id);	
       return  "deleted";
	}
}
