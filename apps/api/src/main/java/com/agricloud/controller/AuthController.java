package com.agricloud.controller;
import org.springframework.web.bind.annotation.RestController;

import com.agricloud.response.GeneralResponse;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.oauth2.core.user.OAuth2User;

@RestController
public class AuthController {

    @GetMapping("/oauth2/authorization/cognito")
    public String handleCognitoAuthorization() {
        return "redirect:/oauth2/authorization/cognito";
    }

    @GetMapping("/login")
    public GeneralResponse login(Authentication authentication) {
        GeneralResponse response = new GeneralResponse();

        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof OAuth2User) {
            OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();

            response.setStatus("Logged in");
            String accessToken = oauth2User.getAttribute("access_token");
            response.setBody(accessToken);
        } else {
            response.setStatus("User not authenticated");
        }
        return response;
    }
}