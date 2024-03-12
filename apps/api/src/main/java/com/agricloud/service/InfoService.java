package com.agricloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agricloud.model.RegionModel;
import com.agricloud.repository.InfoRepository;
import com.agricloud.response.GeneralResponse;

@Service
public class InfoService {
    
    @Autowired
    private InfoRepository infoRepository;

    public GeneralResponse getRegions() {
        
        GeneralResponse response = new GeneralResponse();

        try {
                
            Iterable<RegionModel> regions = infoRepository.findAll();
            response.setStatus("Successfully retrieved regions");
            response.setBody(regions);

        } catch (Exception e) {

            response.setStatus("Error occured retrieved regions");

        }

        return response;

    }

}
