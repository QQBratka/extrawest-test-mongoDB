package com.example.extrawest.service.impl;

import com.example.extrawest.entity.Advertising;
import com.example.extrawest.repository.AdvertisingRepository;
import com.example.extrawest.service.AdvertisingService;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdvertisingServiceImpl implements AdvertisingService {
    private final AdvertisingRepository advertisingRepository;

    public AdvertisingServiceImpl(AdvertisingRepository advertisingRepository) {
        this.advertisingRepository = advertisingRepository;
    }

    @Override
    public List<Advertising> findAll(Pageable pageable) {
        return advertisingRepository.findAll(pageable).toList();
    }
}
