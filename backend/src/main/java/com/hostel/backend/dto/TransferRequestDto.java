package com.hostel.backend.dto;

import jakarta.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransferRequestDto {

    @NotNull(message = "Student ID is required")
    private Long studentId;

    @NotNull(message = "New room ID is required")
    private Long newRoomId;

    private String remarks;
}