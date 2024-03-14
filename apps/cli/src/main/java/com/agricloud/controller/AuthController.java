package com.agricloud.controller;

import com.agricloud.context.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {


    @Autowired
    private UserContext userContext;
    @GetMapping
    public String welcome(Principal principal){
        userContext.setLoggedInUser(principal.getName());
        return "Welcome " + userContext.getLoggedInUser();
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