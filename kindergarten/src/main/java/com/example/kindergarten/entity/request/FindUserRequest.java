package com.example.kindergarten.entity.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FindUserRequest {
    private  String userName;
    private  String email;
    @NotBlank(message = "Phone is not empty")
    private  String phone;
}
