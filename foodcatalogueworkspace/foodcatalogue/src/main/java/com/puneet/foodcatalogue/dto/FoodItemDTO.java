package com.puneet.foodcatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDTO {

	private int itemId;	
	private String itemName;	
	private String itemDescription;	
	private boolean isVeg;	
	private Number itemPrice;
	private Integer restaurantId;	
	private Integer itemQuantity;
	
}
