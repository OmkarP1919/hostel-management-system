package com.hostel.backend.dto;

import com.hostel.backend.enums.AllocationStatus;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AllocationResponseDto {

    private Long allocationId;

    private String studentName;

    private String roomNumber;

    private LocalDate allocationDate;

    private AllocationStatus status;

    private String remarks;
}