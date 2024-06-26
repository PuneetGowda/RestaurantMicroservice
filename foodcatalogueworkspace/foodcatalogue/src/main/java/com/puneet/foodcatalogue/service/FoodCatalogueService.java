package com.puneet.foodcatalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.puneet.foodcatalogue.dao.IFoodItemDAO;
import com.puneet.foodcatalogue.dto.FoodCatalogueDTO;
import com.puneet.foodcatalogue.dto.FoodItemDTO;
import com.puneet.foodcatalogue.dto.RestaurantDTO;
import com.puneet.foodcatalogue.entity.FoodItem;
import com.puneet.foodcatalogue.utilities.FoodItemMapper;

@Service
public class FoodCatalogueService {

	@Autowired
	IFoodItemDAO foodItemDAO;

	@Autowired
	FoodItemMapper foodItemMapper;
	
	@Autowired
	RestTemplate restTemplate;
	
	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
		FoodItem savedFoodItem = foodItemDAO.save(foodItemMapper.mapFoodItemDTOToFoodItem(foodItemDTO));
		return foodItemMapper.mapFoodItemToFoodItemDTO(savedFoodItem);
	}
	
	public FoodCatalogueDTO fetchFoodCataloguePageDetails(Integer restaurantId) {
		List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
		RestaurantDTO restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
		return createFoodCataloguePage(foodItemList, restaurant);
	}

	private FoodCatalogueDTO createFoodCataloguePage(List<FoodItem> foodItemList, RestaurantDTO restaurant) {
		FoodCatalogueDTO foodCatalogueDTO = new FoodCatalogueDTO();
		foodCatalogueDTO.setFoodItemList(foodItemList);
		foodCatalogueDTO.setRestaurant(restaurant);
		
		return foodCatalogueDTO;
	}

	private RestaurantDTO fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
		return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurantsapi/v1/restaurants/"+restaurantId, RestaurantDTO.class);
	}

	private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
		return foodItemDAO.findByRestaurantId(restaurantId);
	}
}
