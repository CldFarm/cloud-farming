package com.agricloud.commands;

import com.agricloud.config.ApiConfig;
import com.agricloud.context.UserContext;
import com.agricloud.controller.AuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.AbstractShellComponent;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.shell.standard.ShellMethod;

import java.net.URI;
import java.net.URISyntaxException;

@ShellComponent("login")
public class AuthCommands extends AbstractShellComponent {

    @Autowired
    private ApiConfig apiConfig;

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    AuthController authController;

    @Autowired
    private UserContext userContext;

    @ShellMethod(key = "login", value = "test command")
    public void login() {
        try {

            URI loginUri = new URI("http://localhost:55555");

            System.out.println("Follow this link to login "+loginUri);


        } catch (URISyntaxException | RestClientException e) {
            System.err.println("Failed to initiate login: " + e.getMessage());
        }
    }


}

