package com.training.orders.model;

import lombok.Data;

@Data
public class PaymentData {
    private String cardNumber;
    private String expDate;
    private Integer ccv;
}
