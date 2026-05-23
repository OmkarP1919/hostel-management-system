package com.hostel.backend.entity;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "fee_structures")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FeeStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne

    @JoinColumn(name = "hostel_building_id")

    private HostelBuilding hostelBuilding;

    private String academicYear;

    private Double annualHostelFee;

    private Double internetCharges;

    private Double washingCharges;

    private Double ironingCharges;

    private Double refundableDeposit;

    private Double totalFees;

    private Boolean active;
}