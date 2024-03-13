package com.agricloud.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {
    @GetMapping
    public String welcome(){

        return "welcome to google";
    }
    @GetMapping("/user")
    public Principal user(Principal principal){
        System.out.println("username :"  + principal.getName());
        return principal;
    }

    @GetMapping("/oauth/token")
    public String oauth(Principal principal){
        System.out.println("username :"  + principal.getName());
        return principal.getName();
    }
}