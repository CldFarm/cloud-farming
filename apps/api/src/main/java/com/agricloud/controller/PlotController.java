package com.agricloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.agricloud.model.PlotModel;
import com.agricloud.response.GeneralResponse;
import com.agricloud.service.PlotService;

@RestController
@RequestMapping("/plot")
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
    
    @PostMapping("/create")
    public GeneralResponse create (@RequestBody PlotModel plot) {
        return plotService.create(plot);
    }

    @DeleteMapping("/{name}") 
    public GeneralResponse delete (@PathVariable(value = "name") String configName) {
        return new GeneralResponse("NOT IMPLEMENTED", null);
    }

    @PostMapping("edit")
    public GeneralResponse putMethodName(@RequestBody String entity) {
        return new GeneralResponse("NOT IMPLEMENTED", null);
    }
    
}
