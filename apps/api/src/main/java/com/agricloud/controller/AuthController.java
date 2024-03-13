package com.agricloud.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agricloud.response.GeneralResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AuthController {

    @GetMapping("/login")
    public String handleLogin() {
        // Redirect the user to the OAuth2 authorization endpoint for Cognito
        String cognitoAuthorizationUrl = "localhost:5000/oauth2/authorization/cognito";
        return "{\"redirect\": \"" + cognitoAuthorizationUrl + "\"}";
    }
}

