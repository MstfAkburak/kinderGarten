package com.example.kindergarten.controller;

import com.example.kindergarten.entity.request.FindUserRequest;
import com.example.kindergarten.model.User;
import com.example.kindergarten.service.UserDetailsServiceImpl;
import com.example.kindergarten.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private UserDetailsServiceImpl userDetailsService;

    public UserController(UserService userService, UserDetailsServiceImpl userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
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

    @GetMapping("/currentUser")
    public String token(){
        return userDetailsService.getCurrentUser();
    }

}
