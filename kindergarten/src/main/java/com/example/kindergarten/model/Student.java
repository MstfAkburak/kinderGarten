package com.example.kindergarten.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Document("student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String id;
    @NotBlank(message = "FirstName is mandatory")
    private String firstName;
    @NotBlank(message = "LastName is mandatory")
    private String lastName;
    @NotBlank(message = "SchoolNumber is mandatory")
    private String schoolNumber;
    @NotBlank(message = "Parent is mandatory")
    private List<String> parent;
    @NotBlank(message = "EmergencyPhone is mandatory")
    private String emergencyPhone;
    @NotBlank(message = "Line is mandatory")
    private String line;


}
