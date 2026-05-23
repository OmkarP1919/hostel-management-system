package com.hostel.backend.dto;

import jakarta.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HostelBuildingRequestDto {

    @NotBlank(message = "Hostel name is required")
    private String hostelName;

    @NotBlank(message = "Hostel type is required")
    private String hostelType;

    @NotNull(message = "Total floors required")
    private Integer totalFloors;

    private String description;
}