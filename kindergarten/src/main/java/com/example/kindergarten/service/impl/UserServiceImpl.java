package com.example.kindergarten.service.impl;

import com.example.kindergarten.entity.request.FindUserRequest;
import com.example.kindergarten.model.Student;
import com.example.kindergarten.model.User;
import com.example.kindergarten.repository.StudentRepository;
import com.example.kindergarten.repository.UserRepository;
import com.example.kindergarten.service.UserDetailsServiceImpl;
import com.example.kindergarten.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    public static final String USERNAME = "username";
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";

    private UserRepository userRepository;
    private UserDetailsServiceImpl userDetailsService;
    private StudentRepository studentRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserDetailsServiceImpl userDetailsService, StudentRepository studentRepository) {
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User findByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUser(FindUserRequest findUserRequest) {
        String channel = decideUserSearch(findUserRequest);
        System.out.println(findUserRequest.toString() );
        switch (channel) {
            case USERNAME: {
                return findByUserName(findUserRequest.getUserName());
            }
            case PHONE: {
                return findByPhone(findUserRequest.getPhone());
            }
            case EMAIL: {
                return findByEmail(findUserRequest.getEmail());
            }
            default: {
                return null;
            }
        }
    }

    @Override
    public User getCurrentUser() {
        String username = userDetailsService.getCurrentUser();
        User user = userRepository.findByUserName(username);
        Student student = studentRepository.findByUserId(user.getId());
        user.setSchoolNumber(student.getSchoolNumber());
        return user;
    }

    private String decideUserSearch(FindUserRequest findUserRequest) {
        if (!StringUtils.isEmpty(findUserRequest.getUserName())) {
            return USERNAME;
        } else if (!StringUtils.isEmpty(findUserRequest.getPhone())) {
            return PHONE;
        } else if (!StringUtils.isEmpty(findUserRequest.getEmail())) {
            return EMAIL;
        }
        return null;
    }
}
