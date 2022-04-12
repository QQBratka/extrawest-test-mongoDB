package com.example.extrawest.dto.mapper;

import com.example.extrawest.dto.request.UserRequestDto;
import com.example.extrawest.dto.response.UserResponseDto;
import com.example.extrawest.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toModel(UserRequestDto requestDto) {
        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());
        return user;
    }

    public UserResponseDto toDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        return responseDto;
    }
}
