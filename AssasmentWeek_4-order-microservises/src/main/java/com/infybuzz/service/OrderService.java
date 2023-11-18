package com.infybuzz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.infybuzz.entity.Order;
import com.infybuzz.repository.OrderRepository;
import com.infybuzz.request.CreateOrderRequest;
import com.infybuzz.response.CustomerResponse;
import com.infybuzz.response.OrderResponse;

import reactor.core.publisher.Mono;
@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    WebClient webClient;

    public OrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        Order order = new Order();

        order.setOrderDate(createOrderRequest.getOrderDate());
        order.setShipToAddress(createOrderRequest.getShipToAddress());
        order.setCustomerId(createOrderRequest.getCustomerId());

        order = orderRepository.save(order);

        OrderResponse orderResponse = new OrderResponse(order);
        orderResponse.setCustomerResponse(getCustomerById(order.getCustomerId()));

        return orderResponse;
    }

    public OrderResponse getOrderById(long id) {
        Order order = orderRepository.findById(id).orElse(null);


        OrderResponse orderResponse = new OrderResponse(order);
        orderResponse.setCustomerResponse(getCustomerById(order.getCustomerId()));

        return orderResponse;
    }

    public CustomerResponse getCustomerById(long customerId) {
        Mono<CustomerResponse> customerResponse = webClient.get()
                .uri("/api/customer/getById/" + customerId)
                .retrieve()
                .bodyToMono(CustomerResponse.class);

        return customerResponse.block();
    }
}
