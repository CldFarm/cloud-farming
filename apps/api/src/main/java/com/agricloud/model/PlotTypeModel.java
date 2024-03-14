package com.agricloud.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Table(name = "plot_type")
@Entity
@NoArgsConstructor
public class PlotTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer plotTypeID;

    private String plotTypeName;
    private BigDecimal plotSize;
    private Integer produceid;
    private Integer defaultConfigid;

}
