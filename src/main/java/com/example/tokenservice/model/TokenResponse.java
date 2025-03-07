package com.example.tokenservice.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenResponse {
	@JsonProperty("auth-vivelibre-token")
    private String token;
    private String date;

    public TokenResponse(String token) {
        this.token = token;
        this.date = LocalDate.now().toString();
    }

    public String getToken() {
        return token;
    }

    public String getDate() {
        return date;
    }
}
