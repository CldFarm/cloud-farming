package com.agricloud.controller;

import com.agricloud.model.ConfigModel;
import com.agricloud.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.agricloud.response.GeneralResponse;


@RestController
@RequestMapping("/configs")
public class ConfigController {

    @Autowired
    ConfigService configService;

    @GetMapping("/user/{user}")
    public GeneralResponse getAll(@PathVariable(value = "user") Integer userID) {
        return configService.getAllUserConfigs(userID);
    }

    @GetMapping("/{id}/info")
    public GeneralResponse info (@PathVariable(value = "id") Integer configID) {
        return configService.getConfigById(configID);
    }

    @PostMapping("/create")
    public GeneralResponse create (@RequestBody ConfigModel config) {
        return configService.createConfig(config);
    }

    @DeleteMapping("/{id}/delete")
    public GeneralResponse delete (@PathVariable(value = "id") Integer configID) {
        return configService.deleteConfig(configID);

    }

    @PostMapping("/edit")
    public GeneralResponse edit (@RequestBody ConfigModel config) {
        return configService.editConfig(config);
    }

}
