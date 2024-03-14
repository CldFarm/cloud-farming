package com.agricloud.api;

import com.agricloud.config.ApiConfig;
import com.agricloud.entity.Config;
import com.agricloud.response.ConfigListResponse;
import com.agricloud.response.ConfigResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Repository
public class ConfigAPI {

    @Autowired
    private ApiConfig apiConfig;

    private final RestTemplate restTemplate = new RestTemplate();

    public ConfigListResponse listAllFromId(Integer userID) {
        try {
            return restTemplate.getForObject(new URI(apiConfig.getEndpoint() + "/configs/user/" + userID), ConfigListResponse.class);
        } catch (RestClientException e) {
            return new ConfigListResponse("Rest Error occured while making request", null);
        } catch (URISyntaxException e) {
            return new ConfigListResponse("URI Error occured while making request", null);
        }
    }

    public ConfigResponse info (@PathVariable(value = "id") Integer configID) {
        try {
            return restTemplate.getForObject(new URI(apiConfig.getEndpoint() + "/configs/" + configID + "/info"), ConfigResponse.class);
        } catch (RestClientException e) {
            return new ConfigResponse("Rest Error occured while making request", null);
        } catch (URISyntaxException e) {
            return new ConfigResponse("URI Error occured while making request", null);
        }
    }

    public ConfigResponse createConfig (Config config) {
        try {
            return restTemplate.postForObject(new URI(apiConfig.getEndpoint() + "/configs/create"), config, ConfigResponse.class);
        } catch (RestClientException e) {
            return new ConfigResponse("Error occured while making request", null);
        } catch (URISyntaxException e) {
            return new ConfigResponse("Error occured while making request", null);
        }
    }

    public ConfigResponse delete (Integer configID) {
        try {
            restTemplate.delete(new URI(apiConfig.getEndpoint() + "/configs/delete/" + configID));
            return new ConfigResponse("Successfully deleted config", null);
        } catch (RestClientException e) {
            return new ConfigResponse("Error occured while making request", null);
        } catch (URISyntaxException e) {
            return new ConfigResponse("Error occured while making request", null);
        }

    }

    @PutMapping("edit")
    public ConfigResponse edit (Config config) {
        try {
            return restTemplate.postForObject(new URI(apiConfig.getEndpoint() + "/configs/edit"), config, ConfigResponse.class);
        } catch (RestClientException e) {
            return new ConfigResponse("Error occured while making request", null);
        } catch (URISyntaxException e) {
            return new ConfigResponse("Error occured while making request", null);
        }
    }

}
