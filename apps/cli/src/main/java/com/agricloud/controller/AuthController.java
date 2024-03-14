package com.agricloud.controller;

import com.agricloud.context.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import java.security.Principal;

@RestController
public class AuthController {

    private String loggedInUser;

   @Autowired
   private UserContext userContext;

    @GetMapping
    public String welcome(Principal principal){
        loggedInUser = principal.getName();
        userContext.setLoggedInUser(loggedInUser);
        return "<h1>Login successful, you may return to the cli</h1> ";
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