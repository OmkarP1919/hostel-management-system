package com.hostel.backend.controller;

import com.hostel.backend.dto.*;

import com.hostel.backend.service.
StudentFeeService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.
PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student-fees")

public class StudentFeeController {

    @Autowired
    private StudentFeeService
            studentFeeService;

    @PostMapping

    @PreAuthorize("hasAuthority('ADMIN')")

    public ApiResponse<StudentFeeResponseDto>
    generateStudentFee(

            @Valid
            @RequestBody
            StudentFeeRequestDto requestDto
    ) {

        StudentFeeResponseDto responseDto =

                studentFeeService
                        .generateStudentFee(
                                requestDto
                        );

        return new ApiResponse<>(

                true,

                "Student fee generated successfully",

                responseDto
        );
    }

    @GetMapping

    public ApiResponse<
            List<StudentFeeResponseDto>
            >
    getAllStudentFees() {

        List<StudentFeeResponseDto>
                fees =

                studentFeeService
                        .getAllStudentFees();

        return new ApiResponse<>(

                true,

                "Student fees fetched successfully",

                fees
        );
    }
}