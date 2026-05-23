package com.hostel.backend.controller;

import com.hostel.backend.dto.*;

import com.hostel.backend.service.
StudentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.
PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping

    @PreAuthorize("hasAuthority('ADMIN')")

    public ApiResponse<StudentResponseDto>
    createStudent(

            @Valid
            @RequestBody
            StudentRequestDto requestDto
    ) {

        StudentResponseDto responseDto =
                studentService.createStudent(
                        requestDto
                );

        return new ApiResponse<>(

                true,

                "Student created successfully",

                responseDto
        );
    }

    @GetMapping

    public ApiResponse<List<StudentResponseDto>>
    getAllStudents() {

        List<StudentResponseDto> students =
                studentService.getAllStudents();

        return new ApiResponse<>(

                true,

                "Students fetched successfully",

                students
        );
    }

    @GetMapping("/search")

public ApiResponse<StudentPageResponseDto>
searchStudents(

        @RequestParam(defaultValue = "")
        String keyword,

        @RequestParam(defaultValue = "0")
        int page,

        @RequestParam(defaultValue = "5")
        int size
) {

    StudentPageResponseDto responseDto =

            studentService.searchStudents(

                    keyword,

                    page,

                    size
            );

    return new ApiResponse<>(

            true,

            "Students fetched successfully",

            responseDto
    );
}
}