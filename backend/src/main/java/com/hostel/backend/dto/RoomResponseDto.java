package com.hostel.backend.dto;

import com.hostel.backend.enums.RoomStatus;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomResponseDto {

    private Long id;

    private String roomNumber;

    private Integer capacity;

    private Integer occupiedBeds;

    private String buildingName;

    private Integer floorNumber;

    private String category;

    private Boolean acEnabled;

    private RoomStatus status;
}