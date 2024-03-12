package com.agricloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agricloud.api.PlotAPI;

@Service
public class PlotService {
    
    @Autowired
    private PlotAPI plotAPI;

    public String test() {
        return plotAPI.test().getStatus();
    }
    
}
