package com.hostel.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserResponseDto {

    private Long id;

    private String fullName;

    private String email;

    private String role;
}