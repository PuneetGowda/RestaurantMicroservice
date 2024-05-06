package com.puneet.foodcatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puneet.foodcatalogue.dto.FoodCatalogueDTO;
import com.puneet.foodcatalogue.dto.FoodItemDTO;
import com.puneet.foodcatalogue.service.FoodCatalogueService;

@RestController
@RequestMapping("/foodcatalogueapi/v1")
public class FoodCatalogueController {

	@Autowired
	FoodCatalogueService foodCatalogueService;
	
	@GetMapping("/restaurantsfooditems/{restaurant_id}")
	public ResponseEntity<FoodCatalogueDTO> fetchRestaurantDetailsWithFoodMenu(@PathVariable Integer restaurant_id) {
		FoodCatalogueDTO foodCatalogueDTO = foodCatalogueService.fetchFoodCataloguePageDetails(restaurant_id);
		return new ResponseEntity<>(foodCatalogueDTO, HttpStatus.OK);
	}
	
	@PostMapping("/fooditems")
	public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
		FoodItemDTO savedFoodItem = foodCatalogueService.addFoodItem(foodItemDTO);
		return new ResponseEntity<>(savedFoodItem, HttpStatus.CREATED);
	}
	
}
