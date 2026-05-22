package com.hostel.backend.dto;

import com.hostel.backend.enums.RoomStatus;

import jakarta.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomRequestDto {

    @NotBlank(message = "Room number is required")
    private String roomNumber;

    @NotNull(message = "Capacity is required")
    private Integer capacity;

    @NotBlank(message = "Building name is required")
    private String buildingName;

    @NotNull(message = "Floor number is required")
    private Integer floorNumber;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "AC status is required")
    private Boolean acEnabled;

    @NotNull(message = "Room status is required")
    private RoomStatus status;
}