package com.example.extrawest.repository;

import java.util.Optional;
import com.example.extrawest.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
