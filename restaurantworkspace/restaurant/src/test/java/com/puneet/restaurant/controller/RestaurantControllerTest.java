package com.puneet.restaurant.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.puneet.restaurant.dto.RestaurantDTO;
import com.puneet.restaurant.service.RestaurantService;

public class RestaurantControllerTest {

	@InjectMocks
	RestaurantController restaurantController;

	@Mock
	RestaurantService restaurantService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this); // in order for Mock and InjectMocks annotations to take effect, you need to
											// call MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testFetchAllRestaurants() {
		// Mock the service behavior
		List<RestaurantDTO> mockRestaurants = Arrays.asList(
				new RestaurantDTO(1, "La Pizzacious", "Bengaluru", "Bengaluru", "Authentic restaurant"),
				new RestaurantDTO(2, "La familia", "Italy", "Italy", "Family restaurant"));
		when(restaurantService.findAllRestaurants()).thenReturn(mockRestaurants);

		// Call the controller method
		ResponseEntity<List<RestaurantDTO>> response = restaurantController.fetchAllRestaurants();

		// Verify the response
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(mockRestaurants, response.getBody());

		// Verify that the service method was called
		verify(restaurantService, times(1)).findAllRestaurants();
	}

	@Test
	public void testSaveRestaurant() {
		// Create a mock restaurant to be saved
		RestaurantDTO mockRestaurant = new RestaurantDTO(1, "La Pizzacious", "Bengaluru", "Bengaluru", "Delicious food from authentic restaurant");

		// Mock the service behavior
		when(restaurantService.addRestaurantInDB(mockRestaurant)).thenReturn(mockRestaurant);

		// Call the controller method
		ResponseEntity<RestaurantDTO> response = restaurantController.saveRestaurant(mockRestaurant);

		// Verify the response
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(mockRestaurant, response.getBody());

		// Verify that the service method was called
		verify(restaurantService, times(1)).addRestaurantInDB(mockRestaurant);
	}

	@Test
	public void testFindRestaurantById() {
		// Create a mock restaurant ID
		Integer mockRestaurantId = 1;

		// Create a mock restaurant to be returned by the service
		RestaurantDTO mockRestaurant = new RestaurantDTO(1, "La Pizzacious", "Bengaluru", "Bengaluru", "Delicious food from authentic restaurant");

		// Mock the service behavior
		when(restaurantService.fetchRestaurantById(mockRestaurantId))
				.thenReturn(new ResponseEntity<>(mockRestaurant, HttpStatus.OK));

		// Call the controller method
		ResponseEntity<RestaurantDTO> response = restaurantController.findRestaurantById(mockRestaurantId);

		// Verify the response
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(mockRestaurant, response.getBody());

		// Verify that the service method was called
		verify(restaurantService, times(1)).fetchRestaurantById(mockRestaurantId);
	}
}