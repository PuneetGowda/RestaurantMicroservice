package com.puneet.restaurant.utilities;

import org.springframework.stereotype.Component;

import com.puneet.restaurant.dto.RestaurantDTO;
import com.puneet.restaurant.entity.Restaurant;

@Component
public class RestaurantMapper {

	public static RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant) {
		RestaurantDTO restaurantDTO = new RestaurantDTO();
		
		restaurantDTO.setRestaurantId(restaurant.getRestaurantId());
		restaurantDTO.setRestaurantName(restaurant.getRestaurantName());
		restaurantDTO.setRestaurantCity(restaurant.getRestaurantCity());
		restaurantDTO.setRestaurantAddress(restaurant.getRestaurantAddress());
		restaurantDTO.setRestaurantDescription(restaurant.getRestaurantDescription());
		
		return restaurantDTO;
	}
	

	public static Restaurant MapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO) {
		Restaurant restaurant = new Restaurant();
		
		restaurant.setRestaurantId(restaurantDTO.getRestaurantId());
		restaurant.setRestaurantName(restaurantDTO.getRestaurantName());
		restaurant.setRestaurantCity(restaurantDTO.getRestaurantCity());
		restaurant.setRestaurantAddress(restaurantDTO.getRestaurantAddress());
		restaurant.setRestaurantDescription(restaurantDTO.getRestaurantDescription());
		
		return restaurant;
	}
 }
