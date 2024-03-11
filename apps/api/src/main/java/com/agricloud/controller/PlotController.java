package com.agricloud.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PlotController {
    
    @GetMapping("/{name}/info")
    public String info (@PathVariable(value = "name") String plotName) {
        return "NOT IMPLEMENTED";
    }

    @GetMapping("/{name}/logs")
    public String logs (@PathVariable(value = "name") String plotName) {
        return "NOT IMPLEMENTED";
    }
    
    @PutMapping("/create")
    public String create (@RequestBody String entity) {
        return "NOT IMPLEMENTED";
    }

    @DeleteMapping("/{name}") 
    public String delete (@PathVariable(value = "name") String configName) {
        return "NOT IMPLEMENTED";
    }

    @PutMapping("edit")
    public String putMethodName(@RequestBody String entity) {
        return "NOT IMPLEMENTED";
    }
    
}
