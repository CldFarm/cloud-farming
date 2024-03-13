package com.agricloud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "region")
@Data
@NoArgsConstructor
public class RegionModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer regionID;

    private String regionName;

}
