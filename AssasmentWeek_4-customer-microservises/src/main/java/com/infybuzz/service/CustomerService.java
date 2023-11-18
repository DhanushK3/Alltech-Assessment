package com.infybuzz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infybuzz.entity.Customer; 
import com.infybuzz.repository.CustomerRepository; 
import com.infybuzz.request.CreateCustomerRequest;
import com.infybuzz.response.CustomerResponse;

@Service
public class CustomerService {

    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {
        Customer customer = new Customer();
        customer.setCustomerFirstName(createCustomerRequest.getCustomerFirstName());
        customer.setCustomerLastName(createCustomerRequest.getCustomerLastName());
        customer.setCustomerAddress(createCustomerRequest.getCustomerAddress());

        customerRepository.save(customer);

        return new CustomerResponse(customer);
    }

    public CustomerResponse getById(long id) {
        logger.info("Inside getById " + id);

        Customer customer = customerRepository.findById(id).get();

    
            return new CustomerResponse(customer);
        
    }
}
