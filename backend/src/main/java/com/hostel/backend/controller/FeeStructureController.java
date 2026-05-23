package com.hostel.backend.controller;

import com.hostel.backend.dto.*;

import com.hostel.backend.service.
FeeStructureService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.
PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")

public class FeeStructureController {

    @Autowired
    private FeeStructureService
            feeStructureService;

    @PostMapping

    @PreAuthorize("hasAuthority('ADMIN')")

    public ApiResponse<FeeStructureResponseDto>
    createFeeStructure(

            @Valid
            @RequestBody
            FeeStructureRequestDto requestDto
    ) {

        FeeStructureResponseDto responseDto =

                feeStructureService
                        .createFeeStructure(
                                requestDto
                        );

        return new ApiResponse<>(

                true,

                "Fee structure created successfully",

                responseDto
        );
    }

    @GetMapping

    public ApiResponse<
            List<FeeStructureResponseDto>
            >
    getAllFeeStructures() {

        List<FeeStructureResponseDto>
                fees =

                feeStructureService
                        .getAllFeeStructures();

        return new ApiResponse<>(

                true,

                "Fee structures fetched successfully",

                fees
        );
    }
}