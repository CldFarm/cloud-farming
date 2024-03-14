package com.agricloud.entity;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Config {

    private Integer configID;

    @Nonnull private String configName;
    @Nonnull private String description;
    private Integer accountID;
    @Nonnull private Integer fertilizerTypeID;
    @Nonnull private BigDecimal waterPerHour;

}