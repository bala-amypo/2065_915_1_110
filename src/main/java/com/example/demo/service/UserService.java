package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {

    User saveUser(User user);

    User getUserById(Long id);

    void deleteUser(Long id);

    User findByEmail(String email);

    List<User> getAllUsers();
}
