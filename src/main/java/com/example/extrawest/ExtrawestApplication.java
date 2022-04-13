package com.example.extrawest;

import com.example.extrawest.entity.Advertising;
import com.example.extrawest.entity.Role;
import com.example.extrawest.entity.User;
import com.example.extrawest.repository.AdvertisingRepository;
import com.example.extrawest.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ExtrawestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExtrawestApplication.class, args);
    }

    @Bean
    CommandLineRunner userRunner(UserRepository userRepository,
                                 AdvertisingRepository advertisingRepository,
                                 PasswordEncoder passwordEncoder) {
        return args -> {
            User user = new User("admin@gmail.com",
                    passwordEncoder.encode("admin"),
                    Role.ADMIN);
            userRepository.insert(user);

            var advertisingList = List.of(
                    new Advertising("phone", "IPhone X", 699,
                            "Egor", "093-766-23-08", LocalDateTime.now()),
                    new Advertising("phone", "Samsung S70", 1149,
                            "Olya", "093-763-23-28", LocalDateTime.now()),
                    new Advertising("phone", "Redmi 10X", 379,
                            "Valera", "093-766-23-77", LocalDateTime.now()),
                    new Advertising("phone", "IPhone 13", 1569,
                            "Sveta", "093-766-23-36", LocalDateTime.now()),
                    new Advertising("phone", "Zoppo ZP11", 250,
                            "Andrey", "093-766-23-14", LocalDateTime.now()),
                    new Advertising("phone", "Nokia N7", 415,
                            "Bogdan", "093-766-23-98", LocalDateTime.now()),
                    new Advertising("phone", "Sony Xperia V8", 580,
                            "Slava", "093-766-23-66", LocalDateTime.now()),
                    new Advertising("car", "Daewoo Nexia", 3700,
                            "Anton", "093-766-23-00", LocalDateTime.now()),
                    new Advertising("car", "Cherry QQ13", 3199,
                            "Katya", "093-766-23-23", LocalDateTime.now()),
                    new Advertising("car", "Chevrolet Lacetti", 4550,
                            "Oksana", "093-766-23-19", LocalDateTime.now()),
                    new Advertising("car", "Toyota Prada", 11899,
                            "Sasha", "093-766-23-54", LocalDateTime.now()),
                    new Advertising("car", "Huyndai Q30", 6900,
                            "Tolik", "093-766-23-21", LocalDateTime.now()),
                    new Advertising("car", "Mazda Q3", 16600,
                            "Vova", "093-766-23-19", LocalDateTime.now()),
                    new Advertising("car", "Chevrolet Bolt", 9800,
                            "Anna", "093-766-23-84", LocalDateTime.now()));
            advertisingRepository.insert(advertisingList);
        };
    }
}
