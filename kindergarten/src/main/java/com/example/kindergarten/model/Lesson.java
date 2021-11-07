package com.example.kindergarten.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("lesson")
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
    private String id;
    private String name;
    private String hour;
}
