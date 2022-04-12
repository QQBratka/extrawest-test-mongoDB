package com.example.extrawest.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "advertising")
@Data
@NoArgsConstructor
public class Advertising {
    @Id
    private String id;
    private String type;
    private String description;
    private int price;
    private String name;
    @Field(name = "phone_number")
    private String phoneNumber;
    @Field(name = "added_at")
    private LocalDateTime addedAt;

    public Advertising(String type,
                       String description,
                       int price,
                       String userName,
                       String phoneNumber,
                       LocalDateTime addedAt) {
        this.type = type;
        this.description = description;
        this.price = price;
        this.name = userName;
        this.phoneNumber = phoneNumber;
        this.addedAt = addedAt;
    }
}
