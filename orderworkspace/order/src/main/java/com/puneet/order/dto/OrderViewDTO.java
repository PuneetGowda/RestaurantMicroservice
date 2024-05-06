package com.puneet.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderViewDTO {

	private int OrderId;
	private List<FoodItemDTO> foodItemList;
	private Integer userId;
	private RestaurantDTO restaurant;
}