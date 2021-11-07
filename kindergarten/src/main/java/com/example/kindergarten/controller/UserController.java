package com.example.kindergarten.controller;

import com.example.kindergarten.entity.request.FindUserRequest;
import com.example.kindergarten.model.User;
import com.example.kindergarten.service.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody User user){
            user.setUserName(user.getFirstName().toLowerCase()+user.getLastName().toLowerCase());
            userService.saveUser(user);
    }

    @PostMapping("/find")
    @ResponseBody
    public User findUser(@RequestBody FindUserRequest request){
        return  userService.findUser(request);
    }
}
