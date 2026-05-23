package com.hostel.backend.dto;

import jakarta.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VacateRequestDto {

    @NotNull(message = "Student ID is required")
    private Long studentId;

    private String remarks;
}