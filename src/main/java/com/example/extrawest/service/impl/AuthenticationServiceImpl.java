package com.example.extrawest.service.impl;

import com.example.extrawest.entity.Role;
import com.example.extrawest.entity.User;
import com.example.extrawest.service.AuthenticationService;
import com.example.extrawest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;

    @Override
    public User register(String email, String password) {
        User user = new User(email, password, Role.USER);
        userService.save(user);
        return user;
    }
}
