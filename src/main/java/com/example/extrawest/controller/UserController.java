package com.example.extrawest.controller;

import com.example.extrawest.dto.request.UserRequestDto;
import com.example.extrawest.dto.response.UserResponseDto;
import com.example.extrawest.entity.User;
import com.example.extrawest.service.AuthenticationService;
import com.example.extrawest.service.UserService;
import com.example.extrawest.dto.mapper.UserMapper;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping
    @PreAuthorize("hasAuthority('users:write')")
    public UserResponseDto create(@RequestBody @Valid UserRequestDto userRequestDto) {
        return userMapper.toDto(authenticationService
                .register(userRequestDto.getEmail(), userRequestDto.getPassword()));
    }

    @PutMapping
    @PreAuthorize("hasAuthority('users:write')")
    public UserResponseDto update(@RequestBody @Valid UserRequestDto requestDto) {
        User user = userMapper.toModel(requestDto);
        if (userService.findByEmail(requestDto.getEmail()).isPresent()) {
            user.setId(userService.findByEmail(requestDto.getEmail()).get().getId());
            user.setRole(userService.findByEmail(requestDto.getEmail()).get().getRole());
            userService.delete(user.getEmail());
            return userMapper.toDto(userService.save(user));
        }
        return userMapper.toDto(authenticationService.register(user.getEmail(), user.getPassword()));
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('users:write')")
    public void delete(@RequestParam String email) {
        userService.delete(email);
    }
}
