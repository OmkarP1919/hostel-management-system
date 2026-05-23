package com.hostel.backend.controller;

import com.hostel.backend.dto.*;

import com.hostel.backend.service.
NoticeService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.
PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @PostMapping

    @PreAuthorize("hasAuthority('ADMIN')")

    public ApiResponse<NoticeResponseDto>
    createNotice(

            @Valid
            @RequestBody
            NoticeRequestDto requestDto
    ) {

        NoticeResponseDto responseDto =

                noticeService.createNotice(
                        requestDto
                );

        return new ApiResponse<>(

                true,

                "Notice created successfully",

                responseDto
        );
    }

    @GetMapping

    public ApiResponse<List<NoticeResponseDto>>
    getAllNotices() {

        List<NoticeResponseDto> notices =

                noticeService.getAllNotices();

        return new ApiResponse<>(

                true,

                "Notices fetched successfully",

                notices
        );
    }
}