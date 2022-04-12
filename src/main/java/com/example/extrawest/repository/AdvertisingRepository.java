package com.example.extrawest.repository;

import com.example.extrawest.entity.Advertising;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisingRepository extends MongoRepository<Advertising, String> {
}
