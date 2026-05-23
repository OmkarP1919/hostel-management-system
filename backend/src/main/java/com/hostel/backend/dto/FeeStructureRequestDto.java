package com.hostel.backend.dto;

import jakarta.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FeeStructureRequestDto {

    @NotNull(message = "Hostel building ID required")
    private Long hostelBuildingId;

    @NotBlank(message = "Academic year required")
    private String academicYear;

    @NotNull
    private Double annualHostelFee;

    @NotNull
    private Double internetCharges;

    @NotNull
    private Double washingCharges;

    @NotNull
    private Double ironingCharges;

    @NotNull
    private Double refundableDeposit;

    @NotNull
    private Boolean active;
}