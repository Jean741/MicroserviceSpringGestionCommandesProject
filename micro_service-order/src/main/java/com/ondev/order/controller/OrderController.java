package com.ondev.order.controller;


import com.ondev.order.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    ResponseEntity<Object> placeOrder(Map<Long,Integer> mapProductsAndQuantites , Long userId){
        return orderService.placeOrder(mapProductsAndQuantites,userId);
    }
}
