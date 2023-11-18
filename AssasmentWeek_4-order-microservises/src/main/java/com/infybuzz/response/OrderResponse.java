package com.infybuzz.response;

import com.infybuzz.entity.Order;

public class OrderResponse {

    private long orderId;

    private Long customerId;

    private String orderDate;

    private String shipToAddress;
    
    private CustomerResponse customerResponse;

    public OrderResponse(Order order) {
        this.orderId = order.getOrderId();
        this.customerId = order.getCustomerId();
        this.orderDate = order.getOrderDate();
        this.shipToAddress = order.getShipToAddress();
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShipToAddress() {
        return shipToAddress;
    }

    public void setShipToAddress(String shipToAddress) {
        this.shipToAddress = shipToAddress;
    }
    
    
    public CustomerResponse getCustomerResponse() {
    	return customerResponse;
    	
    }
	public void setCustomerResponse(CustomerResponse customerResponse) {
		this.customerResponse = customerResponse;
		
	}

	
	
}
