package com.infybuzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.infybuzz.request.CreateOrderRequest;
import com.infybuzz.response.OrderResponse;
import com.infybuzz.service.OrderService;



@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public OrderResponse createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        return orderService.createOrder(createOrderRequest);
    }

    @GetMapping("/getById/{id}")
    public OrderResponse getById(@PathVariable long id) {
        return orderService.getOrderById(id);
    }
}
