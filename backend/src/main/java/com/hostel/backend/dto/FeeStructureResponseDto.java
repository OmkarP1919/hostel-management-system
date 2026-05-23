package com.hostel.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FeeStructureResponseDto {

    private Long id;

    private String hostelName;

    private String academicYear;

    private Double annualHostelFee;

    private Double internetCharges;

    private Double washingCharges;

    private Double ironingCharges;

    private Double refundableDeposit;

    private Double totalFees;

    private Boolean active;
}