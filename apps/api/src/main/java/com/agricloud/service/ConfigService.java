package com.agricloud.service;

import com.agricloud.model.ConfigModel;
import com.agricloud.model.PlotModel;
import com.agricloud.model.PlotTypeModel;
import com.agricloud.repository.ConfigRepository;
import com.agricloud.repository.PlotRepository;
import com.agricloud.repository.PlotTypeRepository;
import com.agricloud.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ConfigService {

    @Autowired
    ConfigRepository configRepository;
    @Autowired
    private PlotRepository plotRepository;
    @Autowired
    PlotTypeRepository plotTypeRepository;

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
            Optional<ConfigModel> configOptional = configRepository.findById(configID);
            configOptional.ifPresentOrElse(config -> {
                response.setStatus("Found config");
                response.setBody(config);
            }, () -> response.setStatus("Found no config with that ID"));
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
            Optional<ConfigModel> configOptional = configRepository.findById(configID);
            configOptional.ifPresentOrElse(config -> {
                // TODO: Propagate changes to Plots using this plot to revert to defaultconfig

                if (!plotTypeRepository.findAllByDefaultConfigid(configID).isEmpty()) {
                    response.setStatus("Config in use as a default config");
                } else {
                    // Update plots to their default config ID.
                    deleteConfigAndUpdatePlots(config);
                    response.setStatus("Deleted config successfully");
                    response.setBody(config);
                }
            }, () -> response.setStatus("Could not find config to delete"));
        } catch (Exception e) {
            response.setStatus("Failed to delete config");
        }
        return response;
    }

    private void deleteConfigAndUpdatePlots(ConfigModel config) {
        // Get all plots that use this config
        List<PlotModel> plotModels = plotRepository.findPlotModelsByConfigID(config.getConfigID());
        for (PlotModel plotModel : plotModels) {
            // for each plot, get their default plot
            PlotTypeModel plotTypeModel = plotTypeRepository.findById(plotModel.getPlotTypeID()).orElseThrow();

            // update their configID, and resave it
            plotModel.setConfigID(plotTypeModel.getDefaultConfigid());
            plotRepository.save(plotModel);
        }
        configRepository.delete(config);
    }

    public GeneralResponse editConfig(ConfigModel config) {
        GeneralResponse response = new GeneralResponse();
        try {
            Optional<ConfigModel> config2Optional = configRepository.findById(config.getConfigID());
            config2Optional.ifPresentOrElse(config2 -> {
//                 if (accountID != config2.getAccountID()) {
//                     response.setStatus("You are not permitted to edit this config");
//                     return response;
//                }
                configRepository.save(config);
                response.setStatus("Successfully edited config");
                response.setBody(config);
            }, () -> {
                response.setStatus("Could not find config to edit");
                response.setBody(config);
            });
        } catch (Exception e) {
            response.setStatus("Failed to edit config");
            response.setBody(e);
        }
        return response;
    }
}
