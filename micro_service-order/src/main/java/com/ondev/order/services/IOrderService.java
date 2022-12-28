package com.ondev.order.services;

import com.ondev.order.entities.Order;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IOrderService {
    ResponseEntity<Object> placeOrder(Map<Long,Integer> mapProductsAndQuantites , Long userId);

	ResponseEntity<Order> updateOrder(Order order);

	ResponseEntity<Order> getOrderById(Long orderId);
}
