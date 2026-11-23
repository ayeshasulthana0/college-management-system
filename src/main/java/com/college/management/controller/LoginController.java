package com.college.management.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.college.management.repository.UserRepository;
import com.college.management.entity.User;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        User existingUser = userRepository
                .findByUsername(user.getUsername())
                .orElse(null);

        if (existingUser == null) {
            return ResponseEntity.badRequest()
                    .body("User not found");
        }

        if (!passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            return ResponseEntity.badRequest()
                    .body("Invalid password");
        }

        existingUser.setPassword(null);

        return ResponseEntity.ok(existingUser);
    }
}