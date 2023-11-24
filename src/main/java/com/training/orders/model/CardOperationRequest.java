package com.training.orders.model;

import lombok.Data;

@Data
public class CardOperationRequest {

    private String cardNumber;
    private String expirationDate;
    private Integer ccv;
    private Integer amount;
    private String commerce;
    private String tid;

    
}
