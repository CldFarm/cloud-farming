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
            response.setStatus("Retrieved user configs");
        } catch (Exception e) {
            response.setStatus("Failed to retrieve user configs");
        }
        return response;
    }

    public GeneralResponse getConfigById(Integer configID) {
        GeneralResponse response = new GeneralResponse();
        try {
            ConfigModel config = configRepository.findConfigByConfigID(configID);
            if (config == null) {
                response.setStatus("Found no config with that ID");
            } else {
                response.setStatus("Found config");
                response.setBody(config);
            }
        } catch (Exception e) {
            response.setStatus("Failed to get Config with ID" + configID);
        }
        return response;
    }

    public GeneralResponse createConfig(ConfigModel config) {
        GeneralResponse response = new GeneralResponse();
        try {
            configRepository.save(config);
            response.setStatus("Created config successfully");
            response.setBody(config);
        } catch (Exception e) {
            response.setStatus("Failed to create config");
            response.setBody(e);
        }
        return response;
    }

    public GeneralResponse deleteConfig(Integer configID) {
        GeneralResponse response = new GeneralResponse();
        try {
            ConfigModel config = configRepository.findConfigByConfigID(configID);
            if (config == null) {
                response.setStatus("Could not find config to delete");
                return response;
            }

            // TODO: Propagate changes to Plots using this plot to revert to defaultconfig
            // TODO: Check that the config isn't in use as a defaultconfig

            // Ensure config isn't in use.
            if (!plotRepository.findPlotModelsByConfigID(configID).isEmpty()) {
                response.setStatus("Config in use");
            } else {
                configRepository.delete(config);
                response.setStatus("Deleted config successfully");
                response.setBody(config);
            }
        } catch (Exception e) {
            response.setStatus("Failed to delete config");
        }
        return response;
    }

    public GeneralResponse editConfig(ConfigModel config) {
        GeneralResponse response = new GeneralResponse();
        try {
            Optional<ConfigModel> config2 = configRepository.findById(config.getConfigID());
            if (config2.isEmpty()) {
                response.setStatus("Could not find config to edit");
                response.setBody(config);
            } else {
                configRepository.save(config);
                response.setStatus("Successfully edited config");
                response.setBody(config);
            }
        } catch (Exception e) {
            response.setStatus("Failed to edit config");
            response.setBody(e);
        }
        return response;
    }
}
