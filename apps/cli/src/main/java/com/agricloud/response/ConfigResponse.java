package com.agricloud.response;

import com.agricloud.entity.Config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigResponse {

    private String status;
    private Config body;

}
