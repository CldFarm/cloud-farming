package com.agricloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/info")
public class InfoController {
    
    @GetMapping("/regions")
    public String regions () {
        return new String();
    }

    @GetMapping("/gz")
    public String growZones () {
        return new String();
    }

    @GetMapping("/fertilizers")
    public String fertilizers () {
        return new String();
    }

    @GetMapping("/plot-types")
    public String plotTypes () {
        return new String();
    }

}
