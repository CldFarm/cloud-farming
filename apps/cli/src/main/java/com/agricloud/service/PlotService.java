package com.agricloud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agricloud.api.PlotAPI;
import com.agricloud.entity.Plot;
import com.agricloud.entity.PlotData;
import com.agricloud.response.PlotDataResponse;
import com.agricloud.response.PlotResponse;
import com.agricloud.context.UserContext;

@Service
public class PlotService {
    
    @Autowired
    private UserContext userContext;

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
        newPlot.setGrowZoneID(growZone);
        newPlot.setPlotTypeID(plotTypeID);
        newPlot.setConfigID(configID);
        newPlot.setTerminated(false);

        PlotResponse response = plotAPI.createPlot(newPlot, userContext.getLoggedInUser());

        return response.getStatus() + Optional.ofNullable(response.getBody())
            .map(
                (body) -> "\n\nPlot Details:\n" + body.toString()
            ).orElse("");
        }

    public String getPlotInfo(
        String plotName
    ) {
        PlotResponse response = plotAPI.getPlotInfo(plotName, userContext.getLoggedInUser());

        return response.getStatus() + Optional.ofNullable(response.getBody())
            .map(
                (body) -> "\n\nPlot Details:\n" + body.toString()
            ).orElse("");

    }

    public String terminate(
        String plotName
    ) {
        PlotResponse response = plotAPI.terminate(plotName, userContext.getLoggedInUser());

        return response.getStatus() + Optional.ofNullable(response.getBody())
            .map(
                (body) -> "\n\nPlot Details:\n" + body.toString()
            ).orElse("");
    
    }

    public String plotStatus(
        String plotName,
        Integer pastHours
    ) {
        PlotDataResponse response = plotAPI.status(plotName, pastHours, userContext.getLoggedInUser());

        String out = response.getStatus() + "\n\nPlot Logs for Past " + pastHours + " Hours:\n";

        out += "[\n";
        for (PlotData plotData : response.getBody()) {
            out += plotData.toString() + ",\n";
        }
        out += "]";

        return out;
    
    }
    
}
