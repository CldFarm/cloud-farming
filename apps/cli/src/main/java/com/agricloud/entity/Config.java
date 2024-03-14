package com.agricloud.entity;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class Config {

    private Integer configID;

    @Nonnull private String configName;
    @Nonnull private String description;
    private Integer accountID;
    @Nonnull private Integer fertilizerTypeID;
    @Nonnull private BigDecimal waterPerHour;

    @Override
    public String toString() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        Field[] fields = this.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                jsonBuilder.append("\n\t\"").append(fields[i].getName()).append("\": ");

                Object value = fields[i].get(this);
                if (value instanceof String || value instanceof Date) {
                    jsonBuilder.append("\"").append(value).append("\"");
                } else {
                    jsonBuilder.append(value.toString());
                }

                if (i < fields.length - 1) {
                    jsonBuilder.append(",");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        jsonBuilder.append("\n}");
        return jsonBuilder.toString();
    }

}