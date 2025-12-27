package com.example.demo.service.impl; 
 
import com.example.demo.entity.User; 
import com.example.demo.repository.UserRepository; 
import com.example.demo.service.UserService; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import java.util.List; 
 
public class UserServiceImpl implements UserService { 
 
    private final UserRepository userRepo; 
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 
 
    public UserServiceImpl(UserRepository userRepository) { 
        this.userRepo = userRepository; 
    } 
 
    @Override 
    public User registerUser(User user) { 
        if (userRepo.existsByEmail(user.getEmail())) { 
            throw new IllegalArgumentException("User already exists"); 
        } 
 
        if (user.getRole() == null) { 
            user.setRole("USER"); 
        } 
 
        user.setPassword(encoder.encode(user.getPassword())); 
        return userRepo.save(user); 
    } 
 
    @Override 
    public User getUser(Long id) { 
        return userRepo.findById(id) 
                .orElseThrow(() -> new RuntimeException("User not found")); 
    } 
 
    @Override 
    public List<User> getAllUsers() { 
        return userRepo.findAll(); 
    } 
}