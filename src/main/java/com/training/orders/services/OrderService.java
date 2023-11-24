package com.training.orders.services;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.orders.model.BuyRequest;
import com.training.orders.model.CardOperationRequest;
import com.training.orders.model.Order;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {

    public static Map<Integer, Order> orders = new HashMap<>();

    private static AtomicInteger counter = new AtomicInteger(0);

    private final CardService  cardService;

    private final TidGeneratorService tidService;

    public String buyOrder(BuyRequest request) {
        Integer nextId = counter.incrementAndGet();
        Order order = request.getOrder();
        order.setId(nextId);
        order.setStatus("PROCCESING");
        orders.put(nextId, order);

        CardOperationRequest opRequest = new CardOperationRequest();
        opRequest.setAmount(order.getTotalPrice());
        
        opRequest.setCommerce("JVA Order System");
        opRequest.setTid(tidService.generateTid());
        opRequest.setCcv(request.getPaymentData().getCcv());
        opRequest.setExpirationDate(request.getPaymentData().getExpDate());
        opRequest.setCardNumber(request.getPaymentData().getCardNumber());

        return cardService.sendPaymentRequest(opRequest);
    }


    
}
