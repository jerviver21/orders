package com.training.orders.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TidGeneratorService {
    
    private static String tidGeneratorUrl = "https://9rhgy6hvzl.execute-api.us-east-1.amazonaws.com/test/tid";

    public String generateTid() {
        RestTemplate client = new RestTemplate();

        ResponseEntity<String> response = client.getForEntity(tidGeneratorUrl,  String.class);

        return response.getBody();
    }
}
