package com.puneet.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puneet.order.dto.OrderDTO;
import com.puneet.order.dto.OrderViewDTO;
import com.puneet.order.service.OrderService;

@RestController
@RequestMapping("/ordersapi/v1")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("/orders")
	public ResponseEntity<List<OrderDTO>> fetchAllOrders() {
		List<OrderDTO> allOrders = orderService.fetchAllOrders();
		return new ResponseEntity<>(allOrders, HttpStatus.OK);
	}
	
	@GetMapping("/orders/{order_id}")
	public ResponseEntity<OrderDTO> fetchOrderById(@PathVariable Integer order_id) {
		return 
				orderService.fetchOrderById(order_id);
	}
	
	@PostMapping("/orders")
	public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderViewDTO orderDetails) {
		OrderDTO savedOrder = orderService.saveOrder(orderDetails);
		return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
	}
	
}
