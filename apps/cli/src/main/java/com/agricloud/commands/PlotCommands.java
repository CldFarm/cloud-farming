package com.agricloud.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.agricloud.service.PlotService;

@ShellComponent("Plot Commands")
public class PlotCommands {
    
    @Autowired
    private PlotService plotService;

    @ShellMethod(key = "plot create", value = "test command")
    public String createPlot() {
        return plotService.test();
    } 

}
