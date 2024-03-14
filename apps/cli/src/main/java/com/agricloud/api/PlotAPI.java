package com.agricloud.api;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.agricloud.config.ApiConfig;
import com.agricloud.entity.Plot;
import com.agricloud.response.PlotResponse;

@Repository
public class PlotAPI {

    @Autowired
    private ApiConfig apiConfig;

    private RestTemplate restTemplate = new RestTemplate();

    public PlotResponse createPlot(Plot plot) {
        try {
            return restTemplate.postForObject(new URI(apiConfig.getEndpoint() + "/plot/create"), plot, PlotResponse.class);
        } catch (RestClientException e) {
            return new PlotResponse("Error occured while making request", null);
        } catch (URISyntaxException e) {
            return new PlotResponse("Error occured while making request", null);
        }
    }    
    
    public PlotResponse getPlotInfo(Integer plotID) {
        try {
            return restTemplate.getForObject(new URI(apiConfig.getEndpoint() + "/plot/" + plotID + "/info"), PlotResponse.class);
        } catch (RestClientException e) {
            return new PlotResponse("Error occured while making request", null);
        } catch (URISyntaxException e) {
            return new PlotResponse("Error occured while making request", null);
        }
    }

    public PlotResponse terminate(Integer plotID) {
        try {
            return restTemplate.postForObject(new URI(apiConfig.getEndpoint() + "/plot/" + plotID + "/terminate"), null, PlotResponse.class);
        } catch (RestClientException e) {
            e.printStackTrace();
            return new PlotResponse("Error occured while making request", null);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return new PlotResponse("Error occured while making request", null);
        }
    }

}
