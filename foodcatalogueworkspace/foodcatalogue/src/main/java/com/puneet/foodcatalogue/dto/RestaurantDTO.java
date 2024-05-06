package com.puneet.foodcatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {

	private int restaurantId;
	private String restaurantName;
	private String restaurantAddress;
	private String restaurantCity;
	private String restaurantDescription;
}
