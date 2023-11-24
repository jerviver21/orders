package com.training.orders.model;

import lombok.Data;

@Data
public class BuyRequest {
    private Order order;
    private PaymentData paymentData;
    
}
