package com.infybuzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.infybuzz.request.CreateCustomerRequest;
import com.infybuzz.response.CustomerResponse;
import com.infybuzz.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/create")
    public CustomerResponse createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return customerService.createCustomer(createCustomerRequest);
    }

    @GetMapping("/getById/{id}")
    public CustomerResponse getById(@PathVariable long id) {
        return customerService.getById(id);
    }
}
