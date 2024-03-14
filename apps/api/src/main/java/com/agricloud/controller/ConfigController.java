package com.agricloud.controller;

import com.agricloud.model.ConfigModel;
import com.agricloud.service.AccountService;
import com.agricloud.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

import com.agricloud.response.GeneralResponse;


@RestController
@RequestMapping("/configs")
public class ConfigController {

    @Autowired
    ConfigService configService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/user/{user}")
    public GeneralResponse getAll(
        @PathVariable(value = "user") String accUID
    ) {
        Integer accID = accountService.accountID(accUID);
        if (accID == null) {
            return new GeneralResponse("Access forbidden!", null); 
        }

        return configService.getAllUserConfigs(accID);
    }

    @GetMapping("/{id}/info")
    public GeneralResponse info (@PathVariable(value = "id") Integer configID) {
        return configService.getConfigById(configID);
    }

    @PostMapping("/create")
    public GeneralResponse create (@RequestBody ConfigModel config) {
        return configService.createConfig(config);
    }

    @PostMapping("/{id}/delete")
    public GeneralResponse delete (@PathVariable(value = "id") Integer configID) {
        return configService.deleteConfig(configID);

    }

    @PostMapping("/edit")
    public GeneralResponse edit (@RequestBody ConfigModel config) {
        return configService.editConfig(config);
    }

}
