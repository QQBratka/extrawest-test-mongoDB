package com.example.extrawest.dto.response;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdvertisingResponseDto {
    private String id;
    private String type;
    private String description;
    private int price;
    private String name;
    private String phoneNumber;
    private LocalDateTime addedAt;
}
