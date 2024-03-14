package com.agricloud.entity;

import java.lang.reflect.Field;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.val;

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
