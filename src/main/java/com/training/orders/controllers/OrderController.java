package com.training.orders.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.orders.model.BuyRequest;
import com.training.orders.model.Order;
import com.training.orders.services.OrderService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class OrderController {

    private OrderService service;

    @GetMapping("/orders")
    public Collection<Order> findOrders(){
        return OrderService.orders.values();
    }

    @PostMapping("/orders")
    public String createOrder(@RequestBody BuyRequest order){
        return service.buyOrder(order);
    }
    
}
