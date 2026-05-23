package com.hostel.backend.dto;

import com.hostel.backend.enums.
PaymentMethod;

import jakarta.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentRequestDto {

    @NotNull
    private Long studentFeeId;

    @NotNull
    private Double amountPaid;

    @NotNull
    private PaymentMethod paymentMethod;

    private String transactionReference;
}