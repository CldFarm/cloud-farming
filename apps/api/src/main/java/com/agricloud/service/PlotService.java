package com.agricloud.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agricloud.model.PlotModel;
import com.agricloud.repository.PlotRepository;
import com.agricloud.response.GeneralResponse;

@Service
public class PlotService {

    @Autowired
    private PlotRepository plotRepository;

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

    @SuppressWarnings("null")
    public GeneralResponse info (Integer plotID) {
        
        GeneralResponse response = new GeneralResponse();

        try {

            plotRepository.findById(plotID)
                .ifPresentOrElse(
                    (plot) -> {
                        response.setBody(plot);
                        response.setStatus("Successfully retrieved plot");
                    }, 
                    () -> {
                        response.setStatus("Plot doesn't exist with ID " + plotID);
                    }
                );

        } catch (Exception e) {

            response.setStatus("Error occured while saving plot");

        }

        return response;

    }

    @SuppressWarnings("null")
    public GeneralResponse terminate (Integer plotID) {

        GeneralResponse response = new GeneralResponse();

        try {

            plotRepository.findById(plotID)
                .ifPresentOrElse(
                    (plot) -> {

                        plot.setTerminated(true);
                        plotRepository.save(plot);

                        response.setBody(plot);
                        response.setStatus("Successfully terminated plot");

                    }, 
                    () -> {
                        response.setStatus("Plot doesn't exist with plotid: " + plotID);
                    }
                );

        } catch (Exception e) {

            response.setStatus("Error occured while saving plot");

        }

        return response;

    }

}
