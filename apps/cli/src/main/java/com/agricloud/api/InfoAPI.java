package com.agricloud.api;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.agricloud.response.GeneralResponse;

@Repository
public class InfoAPI {
    
    private RestTemplate restTemplate = new RestTemplate();

    public GeneralResponse getRegions() {
        try {
            return restTemplate.getForObject(new URI("http://localhost:5000/plot/name/info"), GeneralResponse.class);
        } catch (RestClientException e) {
            return new GeneralResponse("Error occured while making request", null);
        } catch (URISyntaxException e) {
            return new GeneralResponse("Error occured while making request", null);
        }
    }

}
