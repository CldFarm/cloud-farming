package com.agricloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agricloud.response.GeneralResponse;
import com.agricloud.service.InfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/info")
public class InfoController {
    
    @Autowired
    private InfoService infoService;

    @GetMapping("/regions")
    public GeneralResponse regions () {
        return infoService.getRegions();
    }

    @GetMapping("/gz")
    public GeneralResponse growZones () {
        return new GeneralResponse("NOT IMPLEMENTED", null);
    }

    @GetMapping("/fertilizers")
    public GeneralResponse fertilizers () {
        return new GeneralResponse("NOT IMPLEMENTED", null);
    }

    @GetMapping("/plot-types")
    public GeneralResponse plotTypes () {
        return new GeneralResponse("NOT IMPLEMENTED", null);
    }

}
