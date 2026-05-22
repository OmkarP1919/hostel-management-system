package com.hostel.backend.controller;

import com.hostel.backend.dto.*;

import com.hostel.backend.service.RoomService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.
PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping

    @PreAuthorize("hasAuthority('ADMIN')")

    public ApiResponse<RoomResponseDto> createRoom(

            @Valid
            @RequestBody
            RoomRequestDto requestDto
    ) {

        RoomResponseDto responseDto =
                roomService.createRoom(requestDto);

        return new ApiResponse<>(

                true,

                "Room created successfully",

                responseDto
        );
    }

    @GetMapping

    public ApiResponse<List<RoomResponseDto>>
    getAllRooms() {

        List<RoomResponseDto> rooms =
                roomService.getAllRooms();

        return new ApiResponse<>(

                true,

                "Rooms fetched successfully",

                rooms
        );
    }
}