package com.agricloud.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "config")
@NoArgsConstructor
public class ConfigModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer configID;

    @Nonnull private String configName;
    @Nonnull private String description;
    private Integer accountID;
    @Nonnull private Integer fertilizerTypeID;
    @Nonnull private BigDecimal waterPerHour;

}