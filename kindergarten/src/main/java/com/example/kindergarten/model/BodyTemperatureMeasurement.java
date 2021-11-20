package com.example.kindergarten.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("bodyTemperatureMeasurement")
@NoArgsConstructor
@AllArgsConstructor
public class BodyTemperatureMeasurement {
    String id;
    String studentId;
    Double bodyTemperature;
    String date;
    Boolean isEmergency;
}
