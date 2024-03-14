package com.agricloud.api;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.agricloud.config.ApiConfig;
import com.agricloud.entity.Plot;
import com.agricloud.response.PlotDataResponse;
import com.agricloud.response.PlotResponse;

@Repository
public class PlotAPI {

    @Autowired
    private ApiConfig apiConfig;

    private RestTemplate restTemplate = new RestTemplate();

    public PlotResponse createPlot(Plot plot, Integer accID) {
        try {
            return restTemplate.postForObject(new URI(apiConfig.getEndpoint() + "/plot/" + "/create?accID=" + accID), plot, PlotResponse.class);
        } catch (RestClientException e) {
            return new PlotResponse("Error occured while making request", null);
        } catch (URISyntaxException e) {
            return new PlotResponse("Error occured while making request", null);
        }
    }    
    
    public PlotResponse getPlotInfo(String plotName, Integer accID) {
        try {
            return restTemplate.getForObject(new URI(apiConfig.getEndpoint() + "/plot/" + plotName + "/info?accID=" + accID), PlotResponse.class);
        } catch (RestClientException e) {
            return new PlotResponse("Error occured while making request", null);
        } catch (URISyntaxException e) {
            return new PlotResponse("Error occured while making request", null);
        }
    }

    public PlotResponse terminate(String plotName, Integer accID) {
        try {
            return restTemplate.postForObject(new URI(apiConfig.getEndpoint() + "/plot/" + plotName + "/terminate?accID=" + accID), null, PlotResponse.class);
        } catch (RestClientException e) {
            return new PlotResponse("Error occured while making request", null);
        } catch (URISyntaxException e) {
            return new PlotResponse("Error occured while making request", null);
        }
    }

    public PlotDataResponse status(String plotName, Integer pastHours, Integer accID) {
        try {
            return restTemplate.getForObject(
                new URI(apiConfig.getEndpoint() + "/plot/" + plotName + "/status?hours=" + pastHours + "?accID=" + accID), 
                PlotDataResponse.class
            );
        } catch (RestClientException e) {
            e.printStackTrace();
            return new PlotDataResponse("Error occured while making request", null);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return new PlotDataResponse("Error occured while making request", null);
        }
    }

}
