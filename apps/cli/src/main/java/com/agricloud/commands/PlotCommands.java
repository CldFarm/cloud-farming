package com.agricloud.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.AbstractShellComponent;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.Availability;

import com.agricloud.commands.AuthCommands;

import com.agricloud.service.PlotService;
import com.agricloud.context.UserContext;

@ShellComponent("Plot Commands")
public class PlotCommands extends AbstractShellComponent {
    
    @Autowired
    private PlotService plotService;

    @Autowired
    private UserContext userContext;

    @ShellMethod(key = "plot create", value = "test command")
    @ShellMethodAvailability("availabilityCheck")
    public String createPlot(
        @ShellOption(value = "name", help = "Name of the plot") String plotName,
        @ShellOption(value = "desc", help = "Description of the plot") String description,
        @ShellOption(value = "grow-zone", help = "Grow Zone where the plot will be provisioned") int growZone, 
        @ShellOption(value = "plot-type", help = "Type of plot") int plotTypeID,
        @ShellOption(value = "config", help = "Config connected to the plot")  int configID,
        @ShellOption(value = "acc-id", help = "Acc ID") int accID
    ) {
        return plotService.createPlot(plotName, description, growZone, plotTypeID, configID, accID);
    } 

    @ShellMethod(key = "plot info", value = "test command")
    @ShellMethodAvailability("availabilityCheck")
    public String getPlotInfo(
        @ShellOption(value = "plot-name", help = "Plot Name") String plotName,
        @ShellOption(value = "acc-id", help = "Acc ID") int accID
    ) {
        return plotService.getPlotInfo(plotName, accID);        
    } 

    @ShellMethod(key = "plot terminate", value = "test command")
    @ShellMethodAvailability("availabilityCheck")
    public String terminatePlot(
        @ShellOption(value = "plot-name", help = "Plot Name") String plotName,
        @ShellOption(value = "acc-id", help = "Acc ID") int accID
    ) {
        return plotService.terminate(plotName, accID);
    } 

    @ShellMethod(key = "plot status", value = "test command")
    @ShellMethodAvailability("availabilityCheck")
    public String getPlotStatus(
        @ShellOption(value = "plot-name", help = "Plot Name") String plotName,
        @ShellOption(value = "acc-id", help = "Acc ID") int accID,
        @ShellOption(value = "hours", help = "How many hours of plot data from current time") int pastHours
    ) {
        return plotService.plotStatus(plotName, accID, pastHours);
    } 

    public Availability availabilityCheck() {
        boolean connected=false;
         if (userContext.getLoggedInUser()!=null)
            connected = true;
         
        return connected
        ? Availability.available()
        : Availability.unavailable("You are not logged in, use login command to login");
    }

}
