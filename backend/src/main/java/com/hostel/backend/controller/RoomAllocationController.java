package com.hostel.backend.controller;

import com.hostel.backend.dto.*;

import com.hostel.backend.service.
RoomAllocationService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.
PreAuthorize;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/allocations")
public class RoomAllocationController {

    @Autowired
    private RoomAllocationService
            allocationService;

    @PostMapping

    @PreAuthorize("hasAuthority('ADMIN')")

    public ApiResponse<AllocationResponseDto>
    allocateRoom(

            @Valid
            @RequestBody
            AllocationRequestDto requestDto
    ) {

        AllocationResponseDto responseDto =
                allocationService.allocateRoom(
                        requestDto
                );

        return new ApiResponse<>(

                true,

                "Room allocated successfully",

                responseDto
        );
    }

    @PostMapping("/vacate")

@PreAuthorize("hasAuthority('ADMIN')")

public ApiResponse<AllocationResponseDto>
vacateRoom(

        @Valid
        @RequestBody
        VacateRequestDto requestDto
) {

    AllocationResponseDto responseDto =

            allocationService.vacateRoom(
                    requestDto
            );

    return new ApiResponse<>(

            true,

            "Room vacated successfully",

            responseDto
    );
}

@PostMapping("/transfer")

@PreAuthorize("hasAuthority('ADMIN')")

public ApiResponse<AllocationResponseDto>
transferRoom(

        @Valid
        @RequestBody
        TransferRequestDto requestDto
) {

    AllocationResponseDto responseDto =

            allocationService.transferRoom(
                    requestDto
            );

    return new ApiResponse<>(

            true,

            "Room transferred successfully",

            responseDto
    );
}
}