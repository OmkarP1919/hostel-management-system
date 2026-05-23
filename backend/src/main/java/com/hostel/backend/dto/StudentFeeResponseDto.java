package com.hostel.backend.dto;

import com.hostel.backend.enums.
PaymentStatus;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentFeeResponseDto {

    private Long id;

    private String studentName;

    private String hostelName;

    private Double totalAmount;

    private Double paidAmount;

    private Double dueAmount;

    private PaymentStatus paymentStatus;
}