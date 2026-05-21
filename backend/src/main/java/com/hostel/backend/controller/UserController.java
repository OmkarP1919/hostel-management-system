package com.hostel.backend.controller;

import com.hostel.backend.dto.ApiResponse;
import com.hostel.backend.dto.UserRequestDto;
import com.hostel.backend.dto.UserResponseDto;
import com.hostel.backend.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ApiResponse<UserResponseDto> createUser(
            @Valid @RequestBody UserRequestDto requestDto
    ) {

        UserResponseDto responseDto =
                userService.createUser(requestDto);

        return new ApiResponse<>(
                true,
                "User created successfully",
                responseDto
        );
    }

    @GetMapping
    public ApiResponse<List<UserResponseDto>> getAllUsers() {

        List<UserResponseDto> users =
                userService.getAllUsers();

        return new ApiResponse<>(
                true,
                "Users fetched successfully",
                users
        );
    }
}