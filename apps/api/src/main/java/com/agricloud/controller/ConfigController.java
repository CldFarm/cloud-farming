package com.agricloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agricloud.response.GeneralResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/config")
public class ConfigController {
    
    @GetMapping("/{name}/info")
    public GeneralResponse info (@PathVariable(value = "name") String configName) {
        return new GeneralResponse("NOT IMPLEMENTED", null);
    }
    
    @PutMapping("/create")
    public GeneralResponse create (@RequestBody String entity) {
        return new GeneralResponse("NOT IMPLEMENTED", null);
    }

    @DeleteMapping("/{name}") 
    public GeneralResponse delete (@PathVariable(value = "name") String configName) {
        return new GeneralResponse("NOT IMPLEMENTED", null);
    }

    @PutMapping("edit")
    public GeneralResponse putMethodName(@RequestBody String entity) {
        return new GeneralResponse("NOT IMPLEMENTED", null);
    }
    
}
