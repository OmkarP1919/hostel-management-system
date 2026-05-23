package com.hostel.backend.dto;

import com.hostel.backend.enums.*;

import jakarta.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentRequestDto {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Admission number is required")
    private String admissionNumber;

    @NotBlank(message = "Branch is required")
    private String branch;

    @NotNull(message = "Academic year is required")
    private AcademicYear academicYear;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @NotBlank(message = "Guardian name is required")
    private String guardianName;

    @NotBlank(message = "Guardian phone is required")
    private String guardianPhone;

    @NotBlank(message = "Address is required")
    private String address;

    @NotNull(message = "User ID is required")
    private Long userId;
}