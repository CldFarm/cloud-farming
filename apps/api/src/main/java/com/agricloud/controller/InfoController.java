package com.agricloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agricloud.response.GeneralResponse;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/info")
public class InfoController {
    
    @GetMapping("/regions")
    public GeneralResponse regions () {
        return new GeneralResponse("NOT IMPLEMENTED", null);
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
