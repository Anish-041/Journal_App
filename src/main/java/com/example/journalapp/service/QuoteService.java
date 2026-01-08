package com.example.journalapp.service;

import com.example.journalapp.apiResponse.QuoteResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class QuoteService {

    @Value("${weather.api}")
    private String apiURL;

    @Autowired
    private RestTemplate restTemplate;

    public QuoteResponse getQuote() {
        try {
            ResponseEntity<QuoteResponse[]> response = restTemplate.exchange(apiURL, HttpMethod.GET, null, QuoteResponse[].class);
            assert response.getBody() != null;
            return response.getBody()[0];
        } catch (Exception e) {
            log.error("Error getting Quote",e);
            return null;

        }
    }
}
