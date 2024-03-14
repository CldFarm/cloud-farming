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

    @ShellMethod(key = "plot create", value = "test command")
    public String createPlot(
        @ShellOption(value = "name", help = "Name of the plot") String plotName,
        @ShellOption(value = "desc", help = "Description of the plot") String description,
        @ShellOption(value = "grow-zone", help = "Grow Zone where the plot will be provisioned") int growZone, 
        @ShellOption(value = "plot-type", help = "Type of plot") int plotTypeID,
        @ShellOption(value = "config", help = "Config connected to the plot")  int configID
    ) {
        return plotService.createPlot(plotName, description, growZone, plotTypeID, configID);
    } 

    @ShellMethod(key = "plot info", value = "test command")
    public String getPlotInfo(
        @ShellOption(value = "plot-id", help = "Plot ID") int plotID
    ) {
        return plotService.getPlotInfo(plotID);
    } 

    @ShellMethod(key = "plot terminate", value = "test command")
    public String terminatePlot(
        @ShellOption(value = "plot-id", help = "Plot ID") int plotID
    ) {
        return plotService.terminate(plotID);
    } 

    @ShellMethod(key = "plot status", value = "test command")
    public String getPlotStatus(
        @ShellOption(value = "plot-id", help = "Plot ID") int plotID,
        @ShellOption(value = "hours", help = "How many hours of plot data from current time") int pastHours
    ) {
        return plotService.plotStatus(plotID, pastHours);
    } 

}
