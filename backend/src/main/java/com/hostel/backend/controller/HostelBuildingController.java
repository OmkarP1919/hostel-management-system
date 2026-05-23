package com.hostel.backend.controller;

import com.hostel.backend.dto.*;

import com.hostel.backend.service.
HostelBuildingService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.
PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hostels")
public class HostelBuildingController {

    @Autowired
    private HostelBuildingService
            hostelBuildingService;

    @PostMapping

    @PreAuthorize("hasAuthority('ADMIN')")

    public ApiResponse<HostelBuildingResponseDto>
    createHostel(

            @Valid
            @RequestBody
            HostelBuildingRequestDto requestDto
    ) {

        HostelBuildingResponseDto responseDto =

                hostelBuildingService
                        .createHostelBuilding(
                                requestDto
                        );

        return new ApiResponse<>(

                true,

                "Hostel building created successfully",

                responseDto
        );
    }

    @GetMapping

    public ApiResponse<
            List<HostelBuildingResponseDto>
            >
    getAllHostels() {

        List<HostelBuildingResponseDto>
                hostels =

                hostelBuildingService
                        .getAllHostels();

        return new ApiResponse<>(

                true,

                "Hostels fetched successfully",

                hostels
        );
    }
}