package com.example.kindergarten.model;


import com.example.kindergarten.enumModel.MealStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("meal")
@NoArgsConstructor
@AllArgsConstructor
public class Meal {

    private String id;
    private String studentId;
    private Boolean isAttend;
    private String description;
    private String date;
    private MealStatus mealStatus;

}
