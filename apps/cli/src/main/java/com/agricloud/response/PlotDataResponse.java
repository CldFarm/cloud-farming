package com.agricloud.response;

import java.util.List;

import com.agricloud.entity.PlotData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlotDataResponse {
    
    private String status;
    private List<PlotData> body;

}