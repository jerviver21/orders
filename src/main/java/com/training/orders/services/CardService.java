package com.training.orders.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.orders.model.CardOperationRequest;

@Service
public class CardService {
    private static String paymentUrl = "http://localhost:7071/api/createtransaction";

    public String sendPaymentRequest(CardOperationRequest opRequest) {
        RestTemplate paymentClient = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String json = "{}";
        try {
            json = new ObjectMapper().writeValueAsString(opRequest);
        } catch (Exception e) { }


        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

        ResponseEntity<String> response = paymentClient.exchange(paymentUrl, HttpMethod.POST, requestEntity, String.class);

        return response.getBody();
    }
}
