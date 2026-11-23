package com.college.management.controller;

import org.springframework.web.bind.annotation.*;
import com.college.management.entity.User;
import com.college.management.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        savedUser.setPassword(null);
        return savedUser;
    }
}