package com.hostel.backend.entity;

import com.hostel.backend.enums.
PaymentStatus;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "student_fees")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne

    @JoinColumn(name = "student_id")

    private Student student;

    @ManyToOne

    @JoinColumn(name = "fee_structure_id")

    private FeeStructure feeStructure;

    private Double totalAmount;

    private Double paidAmount;

    private Double dueAmount;

    @Enumerated(EnumType.STRING)

    private PaymentStatus paymentStatus;

    private LocalDateTime generatedAt;
}