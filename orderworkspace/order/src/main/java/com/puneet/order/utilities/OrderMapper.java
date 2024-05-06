package com.puneet.order.utilities;

import org.springframework.stereotype.Component;

import com.puneet.order.dto.OrderDTO;
import com.puneet.order.entity.Order;

@Component
public class OrderMapper {

	public OrderDTO mapOrderToOrderDTO(Order order) {
		return new OrderDTO(order.getOrderId(), order.getFoodItemList(), order.getRestaurant(), order.getUserDTO());
	}
	
	public Order mapOrderDTOToOrder(OrderDTO orderDTO) {
		return new Order(orderDTO.getOrderId(), orderDTO.getFoodItemList(), orderDTO.getRestaurant(), orderDTO.getUserDTO());
	}
}
