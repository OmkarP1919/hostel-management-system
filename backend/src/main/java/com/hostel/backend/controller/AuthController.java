package com.hostel.backend.controller;

import com.hostel.backend.dto.*;

import com.hostel.backend.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ApiResponse<UserResponseDto> registerUser(

            @Valid
            @RequestBody
            UserRequestDto requestDto
    ) {

        UserResponseDto responseDto =
                userService.createUser(requestDto);

        return new ApiResponse<>(

                true,

                "User registered successfully",

                responseDto
        );
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponseDto> loginUser(

            @Valid
            @RequestBody
            LoginRequestDto requestDto
    ) {

        LoginResponseDto responseDto =
                userService.loginUser(requestDto);

        return new ApiResponse<>(

                true,

                "Login successful",

                responseDto
        );
    }
}