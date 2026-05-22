package com.hostel.backend.dto;

import com.hostel.backend.enums.Role;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class LoginResponseDto {

    private String token;

    private Long userId;

    private String fullName;

    private String email;

    private Role role;
}