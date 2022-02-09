package com.ondev.order.services.impl;

import com.ondev.order.bean.ProductBean;
import com.ondev.order.dao.OrderRepository;
import com.ondev.order.entities.Order;
import com.ondev.order.proxy.ProductProxy;
import com.ondev.order.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private ProductProxy productProxy;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ResponseEntity<Object> placeOrder(Map<Long,Integer> mapProductsAndQuantites, Long userId) {
        List<Long> idsProduct = new ArrayList<>(mapProductsAndQuantites.keySet());
        List<ProductBean> productBeans = productProxy.getProductsByIds(idsProduct);
        List<Order> orders = productBeans.stream().map(product->createOrder(product.getId(),mapProductsAndQuantites.get(product.getId()),
                userId,product.getPrice()*mapProductsAndQuantites.get(product.getId()))).collect(Collectors.toList());
        orderRepository.saveAll(orders);
        return new ResponseEntity<>("Order saved successfully", HttpStatus.CREATED);
    }

    private Order createOrder(Long id , Integer quantity , Long userId,double totalPrice){
        return  Order.builder()
        		.productId(id)
                .isOrderPaid(false)
                .userId(userId)
                .orderDate(LocalDate.now())
                .quantity(quantity)
                .totalPrice(totalPrice).build();
    }
}
