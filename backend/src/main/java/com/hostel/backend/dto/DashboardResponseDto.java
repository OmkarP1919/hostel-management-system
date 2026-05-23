package com.hostel.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DashboardResponseDto {

    private Long totalStudents;

    private Long totalRooms;

    private Long activeAllocations;

    private Long availableRooms;

    private Long occupiedRooms;

    private Integer totalBeds;

    private Integer occupiedBeds;

    private Integer availableBeds;

    private Double occupancyPercentage;
}