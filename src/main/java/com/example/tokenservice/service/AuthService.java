package com.example.tokenservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.tokenservice.model.TokenResponse;

@Service
public class AuthService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String authUrl = "http://localhost:8080/token";

    public TokenResponse getAuthToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", "auth-vivelibre");
        requestBody.put("password", "password");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.exchange(authUrl, HttpMethod.POST, request, Map.class);

        if (response != null && response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            String token = (String) response.getBody().get("token");
            return new TokenResponse(token);
        }

        return new TokenResponse("ERROR");
    }
}
