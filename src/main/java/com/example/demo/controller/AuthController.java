package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // ✅ Register
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {

        User user = new User(
                request.getFullName(),
                request.getEmail(),
                request.getPassword(),
                "USER"
        );

        return ResponseEntity.ok(userService.saveUser(user));
    }

    // ✅ Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {

        User user = userService.findByEmail(request.getEmail());

        if (user == null || !user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }

        String token = jwtUtil.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return ResponseEntity.ok(token);
    }
}
