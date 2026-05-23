package com.hostel.backend.entity;

import com.hostel.backend.enums.AcademicYear;
import com.hostel.backend.enums.Gender;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "students")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String fullName;

    @Column(unique = true)

    private String admissionNumber;

    private String branch;

    @Enumerated(EnumType.STRING)

    private AcademicYear academicYear;

    @Enumerated(EnumType.STRING)

    private Gender gender;

    private String phoneNumber;

    private String guardianName;

    private String guardianPhone;

    private String address;

    @OneToOne

    @JoinColumn(name = "user_id")

    private User user;
}