package com.hostel.backend.dto;

import com.hostel.backend.enums.
PaymentMethod;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentResponseDto {

    private Long transactionId;

    private String studentName;

    private Double amountPaid;

    private Double remainingDue;

    private PaymentMethod paymentMethod;

    private String transactionReference;

    private LocalDateTime paymentDate;
}