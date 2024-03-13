package com.agricloud.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.AbstractShellComponent;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.agricloud.service.PlotService;

@ShellComponent("Plot Commands")
public class PlotCommands extends AbstractShellComponent {
    
    @Autowired
    private PlotService plotService;

    @ShellMethod(key = "create plot", value = "test command")
    public String createPlot(
        @ShellOption(value = "name", help = "Name of the plot") String plotName,
        @ShellOption(value = "desc", help = "Description of the plot") String description,
        @ShellOption(value = "grow-zone", help = "Grow Zone where the plot will be provisioned") Integer growZone, 
        @ShellOption(value = "plot-type", help = "Type of plot") Integer plotTypeID,
        @ShellOption(value = "config", help = "Config connected to the plot")  Integer configID
    ) {
        return plotService.createPlot(plotName, description, growZone, plotTypeID, configID);
    } 

}
