package com.example.kindergarten.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String id;
    private String firstName;
    private String lastName;
    private String schoolNumber;
    private List<String> veli;
    private String emergencyPhone;
    private String line;


}
