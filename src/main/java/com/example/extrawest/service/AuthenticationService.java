package com.example.extrawest.service;

import com.example.extrawest.entity.User;

public interface AuthenticationService {
    User register(String email, String password);
}
