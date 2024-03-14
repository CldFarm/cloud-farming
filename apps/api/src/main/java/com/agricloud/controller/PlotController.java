package com.agricloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.agricloud.model.PlotModel;
import com.agricloud.response.GeneralResponse;
import com.agricloud.service.AccountService;
import com.agricloud.service.PlotService;

@RestController
@RequestMapping("/plot")
public class PlotController {

    @Autowired
    private PlotService plotService;

    @Autowired
    private AccountService accountService;
    
    @GetMapping("/{name}/info")
    public GeneralResponse info (
        @PathVariable(value = "name") String plotName,
        @RequestParam(value = "accID") String accUID
    ) {
        Integer accID = accountService.accountID(accUID);
        if (accID == null) {
            return new GeneralResponse("Access forbidden!", null); 
        }

        return plotService.info(plotName, accID);
    }

    @GetMapping("/{name}/status")
    public GeneralResponse logs (
        @PathVariable(value = "name") String plotName, 
        @RequestParam(value = "hours", defaultValue = "1") int pastHours,
        @RequestParam(value = "accID") String accUID
    ) {
        Integer accID = accountService.accountID(accUID);
        if (accID == null) {
            return new GeneralResponse("Access forbidden!", null); 
        }

        return plotService.status(plotName, pastHours, accID);
    }
    
    @PostMapping("/create")
    public GeneralResponse create (
        @RequestBody PlotModel plot,
        @RequestParam(value = "accID") String accUID
    ) {
        Integer accID = accountService.accountID(accUID);
        if (accID == null) {
            return new GeneralResponse("Access forbidden!", null); 
        }

        plot.setAccountID(accID);
        return plotService.create(plot);
    }

    @PostMapping("/{name}/terminate") 
    public GeneralResponse terminate (
        @PathVariable(value = "name") String plotName,
        @RequestParam(value = "accID") String accUID
    ) {
        Integer accID = accountService.accountID(accUID);
        if (accID == null) {
            return new GeneralResponse("Access forbidden!", null); 
        }

        return plotService.terminate(plotName, accID);
    }
    
}
