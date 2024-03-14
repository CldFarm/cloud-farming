package com.agricloud.service;

import com.agricloud.api.ConfigAPI;
import com.agricloud.entity.Config;
import com.agricloud.response.ConfigListResponse;
import com.agricloud.response.ConfigResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConfigService {

    @Autowired
    ConfigAPI configAPI;

    public String createConfig(String configName, String description, int fertilizerTypeID, BigDecimal waterPerHour) {
        Config newConfig = new Config();
        newConfig.setConfigName(configName);
        newConfig.setDescription(description);
        newConfig.setFertilizerTypeID(fertilizerTypeID);
        newConfig.setWaterPerHour(waterPerHour);


        ConfigResponse response = configAPI.createConfig(newConfig);

        return response.getStatus() + Optional.ofNullable(response.getBody())
                .map(
                        (body) -> "\n\nConfig Details:" + body.toString()
                ).orElse("");
    }

    public String listAllFromId(int id) {
        ConfigListResponse response = configAPI.listAllFromId(id);
        return response.getStatus() + Optional.ofNullable(response.getBody())
                .map(
                        (body) -> "\n\nAll Configs Details:\n" +
                                body.stream()
                                        .map((config -> config.getConfigID() + " - " + config.getConfigName()))
                                        .collect(Collectors.joining("\n"))
                ).orElse("");
    }

    public String infoConfig(int id) {
        ConfigResponse response = configAPI.info(id);
        return response.getStatus() + Optional.ofNullable(response.getBody())
                .map(
                        (body) -> "\n\nConfig Details:" + body.toString()
                ).orElse("");
    }

    public String deleteConfig(int id) {
        ConfigResponse response = configAPI.delete(id);
        return response.getStatus() + Optional.ofNullable(response.getBody())
                .map(
                        (body) -> "\n\nConfig Details:" + body.toString()
                ).orElse("");
    }

    public String editConfig(int configID, String configName, String description, Integer fertilizerTypeID, BigDecimal waterPerHour) {
        ConfigResponse existingConfigResponse = configAPI.info(configID);
        if (!existingConfigResponse.getStatus().equals("Found config")) {
            return existingConfigResponse.getStatus();
        }
        Config existingConfig = existingConfigResponse.getBody();
        if (configName != null) existingConfig.setConfigName(configName);
        if (description != null) existingConfig.setDescription(description);
        if (fertilizerTypeID != null) existingConfig.setFertilizerTypeID(fertilizerTypeID);
        if (waterPerHour != null) existingConfig.setWaterPerHour(waterPerHour);


        ConfigResponse response = configAPI.edit(existingConfig);

        return response.getStatus() + Optional.ofNullable(response.getBody())
                .map(
                        (body) -> "\n\nConfig Details:" + body.toString()
                ).orElse("");
    }
}
