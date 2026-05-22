package com.hostel.backend.controller;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @GetMapping("/profile")

    @PreAuthorize("hasAuthority('STUDENT')")

    public String studentProfile() {

        return "Welcome Student!";
    }
}