package com.example.tokenservice.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tokenservice.model.TokenResponse;
import com.example.tokenservice.service.AuthService;

@RestController
@RequestMapping("/")
public class TokenController {

    private final AuthService authService;

    public TokenController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/get-token")
    public TokenResponse getToken() {
        return authService.getAuthToken();
    }
}
