package com.example.kindergarten.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("announcement")
@NoArgsConstructor
@AllArgsConstructor
public class Announcement {

    private String id;
    private String date;
    private String description;
}
