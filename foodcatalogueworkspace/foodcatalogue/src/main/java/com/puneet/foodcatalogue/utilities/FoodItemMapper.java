package com.puneet.foodcatalogue.utilities;

import org.springframework.stereotype.Component;

import com.puneet.foodcatalogue.dto.FoodItemDTO;
import com.puneet.foodcatalogue.entity.FoodItem;

@Component
public class FoodItemMapper {

	public FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO) {
		return new FoodItem(foodItemDTO.getItemId(), foodItemDTO.getItemName(), foodItemDTO.getItemDescription(), foodItemDTO.isVeg(), foodItemDTO.getItemPrice(), foodItemDTO.getRestaurantId(), foodItemDTO.getItemQuantity());
	}
	
	public FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem) {
		return new FoodItemDTO(foodItem.getItemId(), foodItem.getItemName(), foodItem.getItemDescription(), foodItem.isVeg(), foodItem.getItemPrice(), foodItem.getRestaurantId(), foodItem.getItemQuantity());
	}
}