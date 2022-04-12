package com.example.extrawest.service;

import com.example.extrawest.entity.User;
import java.util.Optional;

public interface UserService {
    User save(User user);

    Optional<User> findByEmail(String email);

    void delete(String email);
}
