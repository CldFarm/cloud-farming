package com.agricloud.response;

import com.agricloud.entity.Plot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlotResponse {
    
    private String status;
    private Plot body;

}
