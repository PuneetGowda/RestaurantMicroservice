package com.puneet.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

	private int orderId;
	private List<FoodItemDTO> foodItemList;
	private RestaurantDTO restaurant;
	private UserDTO userDTO;
}
