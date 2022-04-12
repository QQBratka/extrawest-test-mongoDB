package com.example.extrawest.service.impl;

import com.example.extrawest.entity.User;
import com.example.extrawest.repository.UserRepository;
import com.example.extrawest.service.UserService;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.insert(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void delete(String email) {
        userRepository.delete(userRepository.findByEmail(email).orElseThrow(() ->
                new RuntimeException("User with such email not exist!")));
    }
}
