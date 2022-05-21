package com.example.kindergarten.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document("dues")
@NoArgsConstructor
@AllArgsConstructor
public class Dues {
    private String id;
    private String studentId;
    private String date;
    private Double value;
    private String paymentDate;
    private Boolean isPaid;
}
