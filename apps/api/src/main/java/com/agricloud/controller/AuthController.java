package com.agricloud.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agricloud.response.GeneralResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @PostMapping("/login")
    public GeneralResponse login(@RequestBody String body) {
        return new GeneralResponse("NOT IMPLEMENTED", null);
    }

}
