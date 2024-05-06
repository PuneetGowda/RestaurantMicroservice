package com.puneet.restaurant.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.puneet.restaurant.dao.IRestaurantDAO;
import com.puneet.restaurant.dto.RestaurantDTO;
import com.puneet.restaurant.entity.Restaurant;
import com.puneet.restaurant.utilities.RestaurantMapper;

public class RestaurantServiceTest {

	@Mock
    IRestaurantDAO restaurantDAO;

    @InjectMocks
    RestaurantService restaurantService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    public void testFindAllRestaurants() {
        // Create mock restaurants
        List<Restaurant> mockRestaurants = Arrays.asList(
                new Restaurant(1, "La Pizzacious", "Bengaluru", "Bengaluru", "Authentic restaurant"),
                new Restaurant(2, "La familia", "Italy", "Italy", "Family restaurant")
        );
        when(restaurantDAO.findAll()).thenReturn(mockRestaurants);

        // Call the service method
        List<RestaurantDTO> restaurantDTOList = restaurantService.findAllRestaurants();

        // Verify the result
        assertEquals(mockRestaurants.size(), restaurantDTOList.size());
        for (int i = 0; i < mockRestaurants.size(); i++) {
            RestaurantDTO expectedDTO = RestaurantMapper.mapRestaurantToRestaurantDTO(mockRestaurants.get(i));
            assertEquals(expectedDTO, restaurantDTOList.get(i));
        }

        // Verify that the repository method was called
        verify(restaurantDAO, times(1)).findAll();
    }

    @Test
    public void testAddRestaurantInDB() {
        // Create a mock restaurant to be saved
        RestaurantDTO mockRestaurantDTO = new RestaurantDTO(1, "La Pizzacious", "Bengaluru", "Bengaluru", "Authentic restaurant");
        Restaurant mockRestaurant = RestaurantMapper.MapRestaurantDTOToRestaurant(mockRestaurantDTO);

        // Mock the repository behavior
        when(restaurantDAO.save(mockRestaurant)).thenReturn(mockRestaurant);

        // Call the service method
        RestaurantDTO savedRestaurantDTO = restaurantService.addRestaurantInDB(mockRestaurantDTO);

        // Verify the result
        assertEquals(mockRestaurantDTO, savedRestaurantDTO);

        // Verify that the repository method was called
        verify(restaurantDAO, times(1)).save(mockRestaurant);
    }

    @Test
    public void testFetchRestaurantById_ExistingId() {
        // Create a mock restaurant ID
        Integer mockRestaurantId = 1;

        // Create a mock restaurant to be returned by the repository
        Restaurant mockRestaurant = new Restaurant(1, "La Pizzacious", "Bengaluru", "Bengaluru", "Authentic restaurant");

        // Mock the repository behavior
        when(restaurantDAO.findById(mockRestaurantId)).thenReturn(Optional.of(mockRestaurant));

        // Call the service method
        ResponseEntity<RestaurantDTO> response = restaurantService.fetchRestaurantById(mockRestaurantId);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockRestaurantId, response.getBody().getRestaurantId());

        // Verify that the repository method was called
        verify(restaurantDAO, times(1)).findById(mockRestaurantId);
    }

    @Test
    public void testFetchRestaurantById_NonExistingId() {
        // Create a mock non-existing restaurant ID
        Integer mockRestaurantId = 1;

        // Mock the repository behavior
        when(restaurantDAO.findById(mockRestaurantId)).thenReturn(Optional.empty());

        // Call the service method
        ResponseEntity<RestaurantDTO> response = restaurantService.fetchRestaurantById(mockRestaurantId);

        // Verify the response
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());

        // Verify that the repository method was called
        verify(restaurantDAO, times(1)).findById(mockRestaurantId);
    }

}
