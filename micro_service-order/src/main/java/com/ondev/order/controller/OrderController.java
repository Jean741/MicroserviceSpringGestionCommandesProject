package com.ondev.order.controller;

import com.ondev.order.entities.Order;
import com.ondev.order.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@PostMapping("/placeOrder/{userId}")
	public ResponseEntity<Object> placeOrder(@RequestBody Map<Long, Integer> mapProductsAndQuantites,
			@PathVariable Long userId) {
		return orderService.placeOrder(mapProductsAndQuantites, userId);
	}

	@PutMapping("/validateOrder")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
		return orderService.updateOrder(order);
	}
	@GetMapping("/getOrderById/{orderId}")
	public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
		return orderService.getOrderById(orderId);
	}
}
