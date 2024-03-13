package com.agricloud.api;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.agricloud.config.ApiConfig;
import com.agricloud.entity.Plot;
import com.agricloud.response.GeneralResponse;

@Repository
public class PlotAPI {

    @Autowired
    private ApiConfig apiConfig;

    private RestTemplate restTemplate = new RestTemplate();

    public GeneralResponse createPlot(Plot plot) {
        try {
            return restTemplate.postForObject(new URI(apiConfig.getEndpoint() + "/plot/create"), plot, GeneralResponse.class);
        } catch (RestClientException e) {
            return new GeneralResponse("Error occured while making request", null);
        } catch (URISyntaxException e) {
            return new GeneralResponse("Error occured while making request", null);
        }
    }     

}
