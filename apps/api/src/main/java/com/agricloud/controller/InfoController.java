package com.agricloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/info")
public class InfoController {
    
    @GetMapping("/regions")
    public String regions () {
        return "NOT IMPLEMENTED";
    }

    @GetMapping("/gz")
    public String growZones () {
        return "NOT IMPLEMENTED";
    }

    @GetMapping("/fertilizers")
    public String fertilizers () {
        return "NOT IMPLEMENTED";
    }

    @GetMapping("/plot-types")
    public String plotTypes () {
        return "NOT IMPLEMENTED";
    }

}
