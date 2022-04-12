package com.example.extrawest.dto.mapper;

import com.example.extrawest.dto.response.AdvertisingResponseDto;
import com.example.extrawest.entity.Advertising;
import org.springframework.stereotype.Component;

@Component
public class AdvertisingMapper {
    public AdvertisingResponseDto toDto(Advertising advertising) {
        AdvertisingResponseDto responseDto = new AdvertisingResponseDto();
        responseDto.setId(advertising.getId());
        responseDto.setType(advertising.getType());
        responseDto.setDescription(advertising.getDescription());
        responseDto.setPrice(advertising.getPrice());
        responseDto.setName(advertising.getName());
        responseDto.setPhoneNumber(advertising.getPhoneNumber());
        responseDto.setAddedAt(advertising.getAddedAt());
        return responseDto;
    }
}
