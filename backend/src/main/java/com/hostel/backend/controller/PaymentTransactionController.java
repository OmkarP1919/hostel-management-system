package com.hostel.backend.controller;

import com.hostel.backend.dto.*;

import com.hostel.backend.service.
PaymentTransactionService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.
PreAuthorize;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")

public class PaymentTransactionController {

    @Autowired
    private PaymentTransactionService
            paymentTransactionService;

    @PostMapping

    @PreAuthorize("hasAuthority('ADMIN')")

    public ApiResponse<PaymentResponseDto>
    makePayment(

            @Valid
            @RequestBody
            PaymentRequestDto requestDto
    ) {

        PaymentResponseDto responseDto =

                paymentTransactionService
                        .makePayment(
                                requestDto
                        );

        return new ApiResponse<>(

                true,

                "Payment completed successfully",

                responseDto
        );
    }
}