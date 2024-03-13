package com.agricloud.api;

import com.agricloud.response.GeneralResponse;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;



public class AuthAPI {

    private RestTemplate restTemplate = new RestTemplate();

    public GeneralResponse login() {
        try {
            return restTemplate.getForObject(new URI("http://localhost:5000"), GeneralResponse.class);
        } catch (RestClientException e) {
            return new GeneralResponse("Error occured while making request", null);
        } catch (URISyntaxException e) {
            return new GeneralResponse("Error occured while making request", null);
        }
    }
}




