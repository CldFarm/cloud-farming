package com.agricloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.agricloud.model.PlotModel;
import com.agricloud.response.GeneralResponse;
import com.agricloud.service.PlotService;

public class PlotController {

    @Autowired
    private PlotService plotService;
    
    @GetMapping("/{name}/info")
    public GeneralResponse info (@PathVariable(value = "name") String plotName) {
        return new GeneralResponse("NOT IMPLEMENTED", null);
    }

    @GetMapping("/{name}/logs")
    public GeneralResponse logs (@PathVariable(value = "name") String plotName) {
        return new GeneralResponse("NOT IMPLEMENTED", null);
    }
    
    @PutMapping("/create")
    public GeneralResponse create (@RequestBody PlotModel plot) {
        return plotService.create(plot);
    }

    @DeleteMapping("/{name}") 
    public GeneralResponse delete (@PathVariable(value = "name") String configName) {
        return new GeneralResponse("NOT IMPLEMENTED", null);
    }

    @PutMapping("edit")
    public GeneralResponse putMethodName(@RequestBody String entity) {
        return new GeneralResponse("NOT IMPLEMENTED", null);
    }
    
}
