package com.example.extrawest.service;

import com.example.extrawest.entity.Advertising;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface AdvertisingService {
    List<Advertising> findAll(Pageable pageable);
}
