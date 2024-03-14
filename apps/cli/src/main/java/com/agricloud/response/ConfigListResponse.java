package com.agricloud.response;

import com.agricloud.entity.Config;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigListResponse {

    private String status;
    private List<Config> body;
}
