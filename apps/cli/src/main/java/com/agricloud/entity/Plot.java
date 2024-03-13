package com.agricloud.entity;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Plot {
    
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
