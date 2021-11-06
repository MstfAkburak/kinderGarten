package com.example.kindergarten.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Document("medicine")
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {

    public String id;
    private String studentName;
    private String medicineName;
    @NotBlank(message = "FirstName is mandatory")
    private Date date;
    @NotBlank(message = "FirstName is mandatory")
    private String hour;
    @NotBlank(message = "FirstName is mandatory")
    private Boolean isUsed;
    @NotBlank(message = "FirstName is mandatory")
    private String description;
}
