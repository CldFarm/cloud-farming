package com.agricloud.service;

import com.agricloud.model.ConfigModel;
import com.agricloud.repository.ConfigRepository;
import com.agricloud.repository.PlotRepository;
import com.agricloud.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ConfigService {

    @Autowired
    ConfigRepository configRepository;
    @Autowired
    private PlotRepository plotRepository;

    public GeneralResponse getAllUserConfigs(Integer accountID) {
        GeneralResponse response = new GeneralResponse();
        try {
            Iterable<ConfigModel> configs = configRepository.findAllByAccountIDOrAccountIDIsNull(accountID);

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

    public GeneralResponse deleteConfig(Integer configID) {
        GeneralResponse response = new GeneralResponse();
        try {
            ConfigModel config = configRepository.findConfigByConfigID(configID);
            if (config == null) {
                response.setStatus("Not Found");
                return response;
            }

            // TODO: Propagate changes to Plots using this plot to revert to defaultconfig
            // TODO: Check that the config isn't in use as a defaultconfig

            // Ensure config isn't in use.
            if (!plotRepository.findPlotModelsByConfigID(configID).isEmpty()) {
                response.setStatus("Config in Use");
            } else {
                configRepository.delete(config);
                response.setStatus("Deleted");
                response.setBody(config);
            }
        } catch (Exception e) {
            response.setStatus("FAILURE");
        }
        return response;
    }

    public GeneralResponse editConfig(ConfigModel config) {
        GeneralResponse response = new GeneralResponse();
        try {
            Optional<ConfigModel> config2 = configRepository.findById(config.getConfigID());
            if (config2.isEmpty()) {
                response.setStatus("NOT FOUND");
                response.setBody(config);
            } else {
                configRepository.save(config);
                response.setStatus("Success");
                response.setBody(config);
            }
        } catch (Exception e) {
            response.setStatus("FAILURE");
            response.setBody(e);
        }
        return response;
    }
}
