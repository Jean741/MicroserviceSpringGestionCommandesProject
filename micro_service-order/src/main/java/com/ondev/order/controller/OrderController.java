package com.ondev.order.controller;


import com.ondev.order.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private IOrderService orderService;


    @PostMapping("/placeOrder/{userId}")
    ResponseEntity<Object> placeOrder(@RequestBody Map<Long,Integer> mapProductsAndQuantites ,@PathVariable Long userId){
        return orderService.placeOrder(mapProductsAndQuantites,userId);
    }
}
