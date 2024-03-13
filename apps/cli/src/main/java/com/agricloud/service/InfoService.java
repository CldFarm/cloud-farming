package com.agricloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agricloud.api.InfoAPI;
import com.agricloud.entity.Region;

@Service
public class InfoService {
    
    @Autowired
    private InfoAPI infoAPI;

    @SuppressWarnings("unchecked")
    public List<Region> getRegions() {
        
        return (List<Region>) infoAPI.getRegions().getBody();

    }

}
