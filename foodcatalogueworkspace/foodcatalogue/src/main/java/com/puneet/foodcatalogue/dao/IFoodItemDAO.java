package com.puneet.foodcatalogue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puneet.foodcatalogue.entity.FoodItem;

@Repository
public interface IFoodItemDAO extends JpaRepository<FoodItem, Integer> {

	List<FoodItem> findByRestaurantId(Integer restaurantId);

}
