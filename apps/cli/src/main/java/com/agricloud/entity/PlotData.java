package com.agricloud.entity;

import java.lang.reflect.Field;
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
