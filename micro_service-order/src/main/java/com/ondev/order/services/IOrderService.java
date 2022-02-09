package com.ondev.order.services;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IOrderService {
    ResponseEntity<Object> placeOrder(Map<Long,Integer> mapProductsAndQuantites , Long userId);
}
