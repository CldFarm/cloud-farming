package com.agricloud.commands;

import com.agricloud.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.AbstractShellComponent;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.math.BigDecimal;

@ShellComponent("Config Commands")
public class ConfigCommands extends AbstractShellComponent {

    @Autowired
    ConfigService configService;

    @ShellMethod(key = "config create", value = "Create config")
    public String createPlot(
            @ShellOption(value = "name", help = "Name of the config") String configName,
            @ShellOption(value = "desc", help = "Description of the config") String description,
            @ShellOption(value = "fertilizer-type", help = "Fertilizer used in the Config") int fertilizerTypeID,
            @ShellOption(value = "water-per-hour", help = "Water use per hour on the config") BigDecimal waterPerHour
    ) {
        return configService.createConfig(configName, description, fertilizerTypeID, waterPerHour);
    }

    @ShellMethod(key = "config list", value = "List your available configs")
    public String listPlots(
            @ShellOption(value = "id", help = "List available configs for the given user") int id
    ) {
        return configService.listAllFromId(id);
    }
}
