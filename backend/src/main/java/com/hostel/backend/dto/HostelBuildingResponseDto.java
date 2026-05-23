package com.hostel.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HostelBuildingResponseDto {

    private Long id;

    private String hostelName;

    private String hostelType;

    private Integer totalFloors;

    private String description;
}