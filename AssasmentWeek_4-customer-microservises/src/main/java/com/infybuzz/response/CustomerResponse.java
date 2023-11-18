package com.infybuzz.response;

import com.infybuzz.entity.Customer; 

public class CustomerResponse {

    private long customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerAddress;

    public CustomerResponse(Customer customer) {
        this.customerId = customer.getCustomerId(); 
        this.customerFirstName = customer.getCustomerFirstName();
        this.customerLastName = customer.getCustomerLastName();
        this.customerAddress = customer.getCustomerAddress();
    }

	public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
