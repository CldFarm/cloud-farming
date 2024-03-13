package com.agricloud.commands;

import com.agricloud.config.ApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.AbstractShellComponent;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@ShellComponent("login")
public class AuthCommands extends AbstractShellComponent {

    @Autowired
    private ApiConfig apiConfig;

    private RestTemplate restTemplate = new RestTemplate();

    @ShellMethod("Login")
    public void login() {
        try {
            // Construct the URI for the login endpoint
//            URI loginUri = new URI(apiConfig.getEndpoint() + "/oauth2/authorization/cognito");
            URI loginUri = new URI("http://localhost:5000/oauth2/authorization/cognito");
            // Open the URI in a browser window
           ;

            System.out.println("Follow this link to login "+loginUri);
        } catch (URISyntaxException | RestClientException e) {
            System.err.println("Failed to initiate login: " + e.getMessage());
        }
    }
}
