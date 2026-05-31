package com.Workflow_Management.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Workflow_Management.dto.LoginRequest;
import com.Workflow_Management.entity.User;
import com.Workflow_Management.respository.UserRepository;
import com.Workflow_Management.security.JwtUtil;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    private JwtUtil jwtUtil = new JwtUtil();

    @PostMapping("/login")
    public Map<String, String> login(
            @RequestBody LoginRequest request) {

        Optional<User> user =
                userRepository.findByEmail(
                        request.getEmail()
                );

        if (user.isPresent()
                && user.get().getPassword()
                .equals(request.getPassword())) {

            String token =
                    jwtUtil.generateToken(
                            user.get().getEmail()
                    );

            Map<String, String> response =
                    new HashMap<>();

            response.put("token", token);
            response.put("role",
                    user.get().getRole());

            return response;
        }

        throw new RuntimeException(
                "Invalid Email or Password"
        );
    }
}