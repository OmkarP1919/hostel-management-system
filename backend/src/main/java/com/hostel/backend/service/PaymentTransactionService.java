package com.hostel.backend.service;

import com.hostel.backend.dto.*;

import com.hostel.backend.entity.*;

import com.hostel.backend.enums.*;

import com.hostel.backend.repository.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentTransactionService {

    @Autowired
    private PaymentTransactionRepository
            paymentTransactionRepository;

    @Autowired
    private StudentFeeRepository
            studentFeeRepository;

    public PaymentResponseDto
    makePayment(

            PaymentRequestDto requestDto
    ) {

        StudentFee studentFee =

                studentFeeRepository.findById(

                        requestDto.getStudentFeeId()

                ).orElseThrow(() ->

                        new RuntimeException(
                                "Student fee not found"
                        )
                );

        if (
                requestDto.getAmountPaid()
                        > studentFee.getDueAmount()
        ) {

            throw new RuntimeException(
                    "Payment exceeds due amount"
            );
        }

        PaymentTransaction transaction =
                new PaymentTransaction();

        transaction.setStudentFee(studentFee);

        transaction.setAmountPaid(
                requestDto.getAmountPaid()
        );

        transaction.setPaymentMethod(
                requestDto.getPaymentMethod()
        );

        transaction.setTransactionReference(
                requestDto.getTransactionReference()
        );

        transaction.setPaymentDate(
                LocalDateTime.now()
        );

        PaymentTransaction savedTransaction =

                paymentTransactionRepository
                        .save(transaction);

        double updatedPaidAmount =

                studentFee.getPaidAmount()

                        + requestDto.getAmountPaid();

        double updatedDueAmount =

                studentFee.getDueAmount()

                        - requestDto.getAmountPaid();

        studentFee.setPaidAmount(
                updatedPaidAmount
        );

        studentFee.setDueAmount(
                updatedDueAmount
        );

        if (updatedDueAmount == 0) {

            studentFee.setPaymentStatus(
                    PaymentStatus.PAID
            );

        } else {

            studentFee.setPaymentStatus(
                    PaymentStatus.PARTIAL
            );
        }

        studentFeeRepository.save(studentFee);

        return new PaymentResponseDto(

                savedTransaction.getId(),

                studentFee.getStudent()
                        .getFullName(),

                requestDto.getAmountPaid(),

                updatedDueAmount,

                requestDto.getPaymentMethod(),

                requestDto.getTransactionReference(),

                savedTransaction.getPaymentDate()
        );
    }
}