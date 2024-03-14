package com.agricloud.controller;

import com.agricloud.context.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {

    private String loggedInUser;

//    @Autowired
//    private UserContext userContext;

    @GetMapping
    public String welcome(Principal principal){
        loggedInUser = principal.getName();
        return "Welcome " + loggedInUser;
//        return "logged in, you can now close the window and return to the cli app";
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