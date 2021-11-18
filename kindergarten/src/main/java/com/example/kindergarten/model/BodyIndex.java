package com.example.kindergarten.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("bodyindex")
@NoArgsConstructor
@AllArgsConstructor
public class BodyIndex {
    private String id;
    private String studentId;
    private int size;
    private Double weight;
    private String date;
}
