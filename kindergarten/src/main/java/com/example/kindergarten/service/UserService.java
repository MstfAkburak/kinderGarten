package com.example.kindergarten.service;

import com.example.kindergarten.entity.request.FindUserRequest;
import com.example.kindergarten.model.User;

public interface UserService {

    void saveUser(User user);

    User findByUserName(String userName);

    User findByPhone(String phone);

    User findByEmail(String email);

    User findUser(FindUserRequest findUserRequest);

    User getCurrentUser();
}
