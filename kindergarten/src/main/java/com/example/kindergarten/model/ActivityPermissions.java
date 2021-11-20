package com.example.kindergarten.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("activityPermissions")
@NoArgsConstructor
@AllArgsConstructor
public class ActivityPermissions {
    private String id;
    private String studentId;
    private String date;
    private Boolean isPermission;
    private String description;
}
