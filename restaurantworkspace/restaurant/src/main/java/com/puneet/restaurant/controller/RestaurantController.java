package com.puneet.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puneet.restaurant.dto.RestaurantDTO;
import com.puneet.restaurant.service.RestaurantService;

@RestController
@RequestMapping("/restaurantsapi/v1")
@CrossOrigin
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;
	
	@GetMapping("/restaurants")
	public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants() {
		List<RestaurantDTO> allRestaurants = restaurantService.findAllRestaurants();
		return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
	}
	
	@GetMapping("/restaurants/{restaurant_id}")
	public ResponseEntity<RestaurantDTO> findRestaurantById(@PathVariable Integer restaurant_id) {
		ResponseEntity<RestaurantDTO> restaurant = restaurantService.fetchRestaurantById(restaurant_id);
		return restaurant;
	}
	
	@PostMapping("/restaurants")
	public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
		RestaurantDTO restaurantAdded = restaurantService.addRestaurantInDB(restaurantDTO);
		return new ResponseEntity<>(restaurantAdded, HttpStatus.CREATED);
	}
	
}