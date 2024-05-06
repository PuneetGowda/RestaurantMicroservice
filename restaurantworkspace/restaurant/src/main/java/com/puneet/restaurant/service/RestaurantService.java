package com.puneet.restaurant.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.puneet.restaurant.dao.IRestaurantDAO;
import com.puneet.restaurant.dto.RestaurantDTO;
import com.puneet.restaurant.entity.Restaurant;
import com.puneet.restaurant.utilities.RestaurantMapper;

@Service
public class RestaurantService {
	
	@Autowired
	IRestaurantDAO restaurantDAO;

	public  List<RestaurantDTO> findAllRestaurants() {
		
		List<Restaurant> restaurants = restaurantDAO.findAll();
		
		List<RestaurantDTO> restaurantDTOList = restaurants.stream().map(restaurant -> RestaurantMapper.mapRestaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
		
		return restaurantDTOList;
	}

	public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
		
		Restaurant savedRestaurant = restaurantDAO.save(RestaurantMapper.MapRestaurantDTOToRestaurant(restaurantDTO));
		return RestaurantMapper.mapRestaurantToRestaurantDTO(savedRestaurant);
	}

	public ResponseEntity<RestaurantDTO> fetchRestaurantById(Integer restaurantId) {
		Optional<Restaurant> restaurant = restaurantDAO.findById(restaurantId);
		if (restaurant.isPresent()) 
			return new ResponseEntity<>(RestaurantMapper.mapRestaurantToRestaurantDTO(restaurant.get()), HttpStatus.OK);
			
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
