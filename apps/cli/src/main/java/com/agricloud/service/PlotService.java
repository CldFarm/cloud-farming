package com.agricloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agricloud.api.PlotAPI;
import com.agricloud.entity.Plot;

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

        return plotAPI.createPlot(newPlot).getStatus();
    }
    
}
