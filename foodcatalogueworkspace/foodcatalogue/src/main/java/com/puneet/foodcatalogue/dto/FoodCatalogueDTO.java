package com.puneet.foodcatalogue.dto;

import java.util.List;

import com.puneet.foodcatalogue.entity.FoodItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCatalogueDTO {

	private List<FoodItem> foodItemList;
	
	private RestaurantDTO restaurant;
}