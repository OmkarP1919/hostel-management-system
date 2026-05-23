package com.hostel.backend.dto;

import jakarta.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentFeeRequestDto {

    @NotNull
    private Long studentId;

    @NotNull
    private Long feeStructureId;
}