package com.agricloud.controller;

import com.agricloud.model.ConfigModel;
import com.agricloud.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agricloud.response.GeneralResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/configs")
public class ConfigController {

    @Autowired
    ConfigService configService;

    @GetMapping("")
    public GeneralResponse getAll() {
        return configService.getAllConfigs();
    }

    @GetMapping("/{id}/info")
    public GeneralResponse info (@PathVariable(value = "id") Integer configID) {
        return configService.getConfigById(configID);
    }

    @PutMapping("/create")
    public GeneralResponse create (@RequestBody ConfigModel config) {
        return configService.createConfig(config);
    }

    @DeleteMapping("/{id}")
    public GeneralResponse delete (@PathVariable(value = "id") Integer configID) {
        return configService.deleteConfig(configID);

    }

    @PutMapping("edit")
    public GeneralResponse edit (@RequestBody ConfigModel config) {
        return configService.editConfig(config);
    }

}
