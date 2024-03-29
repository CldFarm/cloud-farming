package com.agricloud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "api")
@Data
public class ApiConfig {
    
    private String endpoint;

}
