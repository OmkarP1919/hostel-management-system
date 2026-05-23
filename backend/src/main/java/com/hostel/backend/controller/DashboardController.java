package com.hostel.backend.controller;

import com.hostel.backend.dto.*;

import com.hostel.backend.service.
DashboardService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.
PreAuthorize;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping

    @PreAuthorize("hasAuthority('ADMIN')")

    public ApiResponse<DashboardResponseDto>
    getDashboardAnalytics() {

        DashboardResponseDto responseDto =

                dashboardService
                        .getDashboardAnalytics();

        return new ApiResponse<>(

                true,

                "Dashboard analytics fetched successfully",

                responseDto
        );
    }
}