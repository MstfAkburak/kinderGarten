package com.example.kindergarten.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@Document("lessons")
@NoArgsConstructor
@AllArgsConstructor
public class Lessons {
    private String id;
    private List<Lesson> lesson;
    private String grade;

}
