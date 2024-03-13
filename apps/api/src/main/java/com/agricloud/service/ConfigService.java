package com.agricloud.service;

import com.agricloud.model.ConfigModel;
import com.agricloud.repository.ConfigRepository;
import com.agricloud.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConfigService {

    @Autowired
    ConfigRepository configRepository;

    public GeneralResponse getAllConfigs() {
        GeneralResponse response = new GeneralResponse();
        try {
            Iterable<ConfigModel> configs = configRepository.findAll();
            response.setBody(configs);
            response.setStatus("Success");
        } catch (Exception e) {
            response.setStatus("Failure");
        }
        return response;
    }

    public GeneralResponse getConfigById(Integer configID) {
        GeneralResponse response = new GeneralResponse();
        try {
            ConfigModel config = configRepository.findConfigByConfigID(configID);
            if (config == null) {
                response.setStatus("Not Found");
            } else {
                response.setStatus("Found");
                response.setBody(config);
            }
        } catch (Exception e) {
            response.setStatus("FAILURE");
        }
        return response;
    }

    public GeneralResponse createConfig(ConfigModel config) {
        GeneralResponse response = new GeneralResponse();
        try {
            configRepository.save(config);
            response.setStatus("Success");
            response.setBody(config);
        } catch (Exception e) {
            response.setStatus("FAILURE");
            response.setBody(e);
        }
        return response;
    }
}
