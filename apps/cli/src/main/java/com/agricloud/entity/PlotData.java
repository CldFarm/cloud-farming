package com.agricloud.entity;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlotData {
    
    private Integer plotDataID;
    private Integer plotID;
    private Double growthPercent;
    private Double sunlight;
    private Double soilMoisture;
    private Date timeTaken;

}
