package com.hostel.backend.dto;

import com.hostel.backend.enums.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentResponseDto {

    private Long id;

    private String fullName;

    private String admissionNumber;

    private String branch;

    private AcademicYear academicYear;

    private Gender gender;

    private String phoneNumber;

    private String guardianName;

    private String guardianPhone;

    private String address;

    private String email;
}