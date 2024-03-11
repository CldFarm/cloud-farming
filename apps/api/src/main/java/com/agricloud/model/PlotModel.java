package com.agricloud.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plot")
@Data
@NoArgsConstructor
public class PlotModel {
    
    @Id
    @GeneratedValue
    private Integer plotID;

    private String plotName;
    private String description;
    private Integer accountID;
    private Integer growZoneID;
    private Integer plotTypeID;
    private Integer configID;
    private Date creationDate;
    private Boolean terminated;

}
