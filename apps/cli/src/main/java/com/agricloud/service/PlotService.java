package com.agricloud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agricloud.api.PlotAPI;
import com.agricloud.entity.Plot;
import com.agricloud.response.PlotResponse;

@Service
public class PlotService {
    
    @Autowired
    private PlotAPI plotAPI;

    public String createPlot(
        String plotName,
        String description,
        Integer growZone, 
        Integer plotTypeID,
        Integer configID
    ) {
        Plot newPlot = new Plot();
        newPlot.setPlotName(plotName);
        newPlot.setDescription(description);
        newPlot.setAccountID(1);
        newPlot.setGrowZoneID(growZone);
        newPlot.setPlotTypeID(plotTypeID);
        newPlot.setConfigID(configID);
        newPlot.setTerminated(false);

        PlotResponse response = plotAPI.createPlot(newPlot);

        return response.getStatus() + Optional.ofNullable(response.getBody())
            .map(
                (body) -> "\n\nPlot Details:" + body.toString()
            ).orElse("");
        }

    public String getPlotInfo(
        Integer plotID
    ) {
        PlotResponse response = plotAPI.getPlotInfo(plotID);

        return response.getStatus() + Optional.ofNullable(response.getBody())
            .map(
                (body) -> "\n\nPlot Details:" + body.toString()
            ).orElse("");

    }

    public String terminate(
        Integer plotID
    ) {
        PlotResponse response = plotAPI.terminate(plotID);

        return response.getStatus() + Optional.ofNullable(response.getBody())
            .map(
                (body) -> "\n\nPlot Details:" + body.toString()
            ).orElse("");
    
    }
    
}
