package com.puneet.order.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.puneet.order.dao.IOrderDAO;
import com.puneet.order.dto.OrderDTO;
import com.puneet.order.dto.OrderViewDTO;
import com.puneet.order.dto.UserDTO;
import com.puneet.order.entity.Order;
import com.puneet.order.utilities.OrderMapper;

@Service
public class OrderService {

	@Autowired
	IOrderDAO orderDAO;
	
	@Autowired
	SequenceGenerator sequenceGenerator;
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	OrderMapper orderMapper;
	
	public OrderDTO saveOrder(OrderViewDTO orderDetails) {
		
		int newOrderId = sequenceGenerator.generateNextOrderId();
		
		UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
		
		Order savedOrder = orderDAO.save(new Order(newOrderId, orderDetails.getFoodItemList(), orderDetails.getRestaurant(), userDTO));
		
		return orderMapper.mapOrderToOrderDTO(savedOrder);
	}

	private UserDTO fetchUserDetailsFromUserId(Integer userId) {
		return restTemplate.getForObject("http://USER-SERVICE/usersapi/v1/users/"+userId, UserDTO.class);
	}

	public List<OrderDTO> fetchAllOrders() {
		return orderDAO.findAll().stream().map(order -> orderMapper.mapOrderToOrderDTO(order)).collect(Collectors.toList());
	}

	public ResponseEntity<OrderDTO> fetchOrderById(Integer order_id) {
		
		Optional<Order> order = orderDAO.findById(order_id);
		if (order.isPresent()) {
			return new ResponseEntity<>(orderMapper.mapOrderToOrderDTO(order.get()), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}