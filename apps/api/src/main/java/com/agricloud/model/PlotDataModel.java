package com.agricloud.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plot_data")
@Data
@NoArgsConstructor
public class PlotDataModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer plotDataID;

    private Integer plotID;
    private Double growthPercent;
    private Double sunlight;
    private Double soilMoisture;
    private Date timeTaken;

}
