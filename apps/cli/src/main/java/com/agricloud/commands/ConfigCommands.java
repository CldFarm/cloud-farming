package com.agricloud.commands;

import com.agricloud.context.UserContext;
import com.agricloud.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.component.ConfirmationInput;
import org.springframework.shell.standard.*;

import java.math.BigDecimal;

@ShellComponent("Config Commands")
public class ConfigCommands extends AbstractShellComponent {

    @Autowired
    ConfigService configService;

    @Autowired
    private UserContext userContext;

    @ShellMethod(key = "config create", value = "Create config")
    @ShellMethodAvailability("availabilityCheck")
    public String configCreate(
            @ShellOption(value = "name", help = "Name of the config") String configName,
            @ShellOption(value = "desc", help = "Description of the config") String description,
            @ShellOption(value = "fertilizer-type", help = "Fertilizer used in the config") int fertilizerTypeID,
            @ShellOption(value = "water-per-hour", help = "Water use per hour on the config") BigDecimal waterPerHour
    ) {
        return configService.createConfig(configName, description, fertilizerTypeID, waterPerHour);
    }

    @ShellMethod(key = "config list", value = "List your available configs")
    @ShellMethodAvailability("availabilityCheck")
    public String configsUserList(
            @ShellOption(value = "id", help = "List available configs for the given user") int id
    ) {
        return configService.listAllFromId(Integer.parseInt(userContext.getLoggedInUser()));
    }

    @ShellMethod(key = "config info", value = "Get information about a config")
    @ShellMethodAvailability("availabilityCheck")
    public String configInfo(
            @ShellOption int id
    ) {
        return configService.infoConfig(id);
    }

    @ShellMethod(key = "config delete", value = "Delete a config")
    @ShellMethodAvailability("availabilityCheck")
    public String configDelete(
            @ShellOption int id
    ) {

        ConfirmationInput component = new ConfirmationInput(getTerminal(), "Confirm deletion of config " + id + ":");
        component.setResourceLoader(getResourceLoader());
        component.setTemplateExecutor(getTemplateExecutor());
        ConfirmationInput.ConfirmationInputContext context = component.run(ConfirmationInput.ConfirmationInputContext.empty());
        if (context.getResultValue()) {
            return configService.deleteConfig(id);
        }
        return "";
    }

    @ShellMethod(key = "config edit", value = "Edit config")
    @ShellMethodAvailability("availabilityCheck")
    public String configEdit(
            @ShellOption(value = "id", help = "ID of the config") int configID,
            @ShellOption(value = "name", help = "Name of the config", defaultValue = ShellOption.NULL) String configName,
            @ShellOption(value = "desc", help = "Description of the config", defaultValue = ShellOption.NULL) String description,
            @ShellOption(value = "fertilizer-type", help = "Fertilizer used in the config", defaultValue = ShellOption.NULL) Integer fertilizerTypeID,
            @ShellOption(value = "water-per-hour", help = "Water use per hour on the config", defaultValue = ShellOption.NULL) BigDecimal waterPerHour
    ) {
        return configService.editConfig(configID, configName, description, fertilizerTypeID, waterPerHour);
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
