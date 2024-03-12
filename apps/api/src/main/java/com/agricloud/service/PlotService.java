package com.agricloud.service;

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
                
                plotRepository.save(plot);
                response.setStatus("Successfully saved pod");
                response.setBody(response);

            } catch (Exception e) {

                response.setStatus("Error occured with saving pod");

            }

        } else {

            response.setStatus("Pod cannot be null");
            
        }

        return response;

    }

    public GeneralResponse info (String plotName) {
        
        GeneralResponse response = new GeneralResponse();

        try {
                
            // plotRepository.findById(plot);
            response.setStatus("Successfully saved pod");
            response.setBody(response);

        } catch (Exception e) {

            response.setStatus("Error occured while saving pod");

        }

        return response;

    }

}