package com.agricloud.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.agricloud.model.PlotDataModel;
import com.agricloud.model.PlotModel;
import com.agricloud.repository.PlotDataRepository;
import com.agricloud.repository.PlotRepository;
import com.agricloud.response.GeneralResponse;

@Service
public class PlotService {

    private final PlotRepository plotRepository;

    private final PlotDataRepository plotDataRepository;

    public PlotService(PlotRepository plotRepository, PlotDataRepository plotDataRepository) {
        this.plotDataRepository = plotDataRepository;
        this.plotRepository = plotRepository;
    }

    public GeneralResponse create (PlotModel plot) {

        GeneralResponse response = new GeneralResponse();

        if (plot != null) {

            try {
                
                plot.setCreationDate(new Date());
                plotRepository.save(plot);
                response.setStatus("Successfully saved plot");
                response.setBody(plot);

            } catch (Exception e) {

                e.printStackTrace();
                response.setStatus("Error occured with saving plot");

            }

        } else {

            response.setStatus("Plot cannot be null");
            
        }

        return response;

    }

    public GeneralResponse info (String plotName, Integer userToken) {
        
        GeneralResponse response = new GeneralResponse();

        try {

            plotRepository.findPlotModelByAccountIDAndPlotName(userToken, plotName)
                .ifPresentOrElse(
                    (plot) -> {
                        response.setBody(plot);
                        response.setStatus("Successfully retrieved plot");
                    }, 
                    () -> {
                        response.setStatus("Plot doesn't exist with name " + plotName);
                    }
                );

        } catch (Exception e) {

            response.setStatus("Error occured while saving plot");

        }

        return response;

    }

    public GeneralResponse terminate (String plotName, Integer userToken) {

        GeneralResponse response = new GeneralResponse();

        try {

            plotRepository.findPlotModelByAccountIDAndPlotName(userToken, plotName)
                .ifPresentOrElse(
                    (plot) -> {

                        plot.setTerminated(true);
                        plotRepository.save(plot);

                        response.setBody(plot);
                        response.setStatus("Successfully terminated plot");

                    }, 
                    () -> {
                        response.setStatus("Plot doesn't exist with plot name: " + plotName);
                    }
                );

        } catch (Exception e) {

            response.setStatus("Error occured while saving plot");

        }

        return response;

    }

    public GeneralResponse status (Integer plotID, Integer pastHours, Integer userToken) {

        GeneralResponse response = new GeneralResponse();

        try {

            LocalDateTime currentDateTime = LocalDateTime.now();
            LocalDateTime oneHourAgo = currentDateTime.minusHours(pastHours);
            Date hoursAgo = Date.from(oneHourAgo.atZone(ZoneId.systemDefault()).toInstant());

            response.setBody(plotDataRepository.getPlotDataForPastHours(plotID, hoursAgo));
            response.setStatus("Succesfully retrieved plot data");

        } catch (Exception e) {

            e.printStackTrace();
            response.setStatus("Error occured while retrieving plot data");

        }

        return response;

    }

    @Scheduled(cron = "0 */30 * * * *") // Run every 30 minutes
    private void trackPlotData() {

        plotRepository.findAll().forEach(
            (plot) -> {
                if (!plot.getTerminated()) {
                    PlotDataModel plotDataModel = new PlotDataModel();
                    plotDataModel.setPlotID(plot.getPlotID());
                    plotDataModel.setGrowthPercent(getRandomPerc());
                    plotDataModel.setSunlight(getRandomPerc());
                    plotDataModel.setSoilMoisture(getRandomPerc());
    
                    plotDataRepository.save(plotDataModel);
                }
            }
        );

    }

    private Double getRandomPerc() {

        Random random = new Random();
        double randomValue = random.nextDouble() * 100;
        return Math.round(randomValue * 100.0) / 100.0;

    }

}
