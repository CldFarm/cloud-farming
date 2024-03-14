package com.agricloud.response;

import com.agricloud.entity.PlotData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlotDataResponse {
    
    private String status;
    private PlotData body;

}