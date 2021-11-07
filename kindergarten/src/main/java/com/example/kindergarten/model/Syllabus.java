package com.example.kindergarten.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Document("syllabus")
@NoArgsConstructor
@AllArgsConstructor
public class Syllabus {
    private String id;
    private List<Lesson> lesson;
    private String grade;

}
