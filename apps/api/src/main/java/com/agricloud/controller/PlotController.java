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
    public GeneralResponse info (
        @PathVariable(value = "name") String plotName,
        @RequestParam(value = "accID") int accID
    ) {
        return plotService.info(plotName, accID);
    }

    @GetMapping("/{name}/status")
    public GeneralResponse logs (
        @PathVariable(value = "name") int plotID, 
        @RequestParam(value = "hours", defaultValue = "1") int pastHours,
        @RequestParam(value = "accID") int accID
    ) {
        return plotService.status(plotID, pastHours, accID);
    }
    
    @PostMapping("/create")
    public GeneralResponse create (@RequestBody PlotModel plot) {
        return plotService.create(plot);
    }

    @PostMapping("/{name}/terminate") 
    public GeneralResponse terminate (
        @PathVariable(value = "name") String plotName,
        @PathVariable(value = "accID") int accID
    ) {
        return plotService.terminate(plotName, accID);
    }
    
}
