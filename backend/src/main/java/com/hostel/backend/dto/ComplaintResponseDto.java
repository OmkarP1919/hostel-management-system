package com.hostel.backend.dto;

import com.hostel.backend.enums.ComplaintStatus;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ComplaintResponseDto {

    private Long id;

    private String title;

    private String description;

    private String category;

    private ComplaintStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime resolvedAt;

    private String studentName;
}