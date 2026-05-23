package com.hostel.backend.controller;

import com.hostel.backend.dto.*;

import com.hostel.backend.service.
ComplaintService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping

    public ApiResponse<ComplaintResponseDto>
    createComplaint(

            @Valid
            @RequestBody
            ComplaintRequestDto requestDto
    ) {

        ComplaintResponseDto responseDto =

                complaintService.createComplaint(
                        requestDto
                );

        return new ApiResponse<>(

                true,

                "Complaint created successfully",

                responseDto
        );
    }

    @GetMapping

    public ApiResponse<List<ComplaintResponseDto>>
    getAllComplaints() {

        List<ComplaintResponseDto> complaints =

                complaintService.getAllComplaints();

        return new ApiResponse<>(

                true,

                "Complaints fetched successfully",

                complaints
        );
    }

    @PutMapping("/{complaintId}/status")

@PreAuthorize("hasAuthority('ADMIN')")

public ApiResponse<ComplaintResponseDto>
updateComplaintStatus(

        @PathVariable
        Long complaintId,

        @Valid
        @RequestBody
        ComplaintStatusUpdateDto requestDto
) {

    ComplaintResponseDto responseDto =

            complaintService
                    .updateComplaintStatus(

                            complaintId,

                            requestDto
                    );

    return new ApiResponse<>(

            true,

            "Complaint status updated successfully",

            responseDto
    );
}
}