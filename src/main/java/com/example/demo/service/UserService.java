package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(Long id);   // add this
    User createUser(User user);
}
