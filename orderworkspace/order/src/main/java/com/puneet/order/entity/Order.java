package com.puneet.order.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.puneet.order.dto.FoodItemDTO;
import com.puneet.order.dto.RestaurantDTO;
import com.puneet.order.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	private int orderId;
	private List<FoodItemDTO> foodItemList;
	private RestaurantDTO restaurant;
	private UserDTO userDTO;
}
