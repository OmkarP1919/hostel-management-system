package com.hostel.backend.entity;

import com.hostel.backend.enums.
PaymentMethod;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment_transactions")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne

    @JoinColumn(name = "student_fee_id")

    private StudentFee studentFee;

    private Double amountPaid;

    @Enumerated(EnumType.STRING)

    private PaymentMethod paymentMethod;

    private String transactionReference;

    private LocalDateTime paymentDate;
}