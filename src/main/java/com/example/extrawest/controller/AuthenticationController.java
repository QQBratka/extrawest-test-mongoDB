package com.example.extrawest.controller;

import com.example.extrawest.dto.request.UserRequestDto;
import com.example.extrawest.dto.response.UserResponseDto;
import com.example.extrawest.entity.User;
import com.example.extrawest.service.AuthenticationService;
import com.example.extrawest.dto.mapper.UserMapper;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        User user = authenticationService.register(requestDto.getEmail(), requestDto.getPassword());
        return userMapper.toDto(user);
    }
}
