package com.example.kindergarten.exception.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private int code;
    private Map<String, String> validations;
}
