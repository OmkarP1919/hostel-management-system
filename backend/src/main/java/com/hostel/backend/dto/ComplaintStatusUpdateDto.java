package com.hostel.backend.dto;

import com.hostel.backend.enums.ComplaintStatus;

import jakarta.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ComplaintStatusUpdateDto {

    @NotNull(message = "Complaint status is required")
    private ComplaintStatus status;
}