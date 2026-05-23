package com.hostel.backend.entity;

import com.hostel.backend.enums.ComplaintStatus;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "complaints")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String title;

    @Column(length = 1000)

    private String description;

    private String category;

    @Enumerated(EnumType.STRING)

    private ComplaintStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime resolvedAt;

    @ManyToOne

    @JoinColumn(name = "student_id")

    private Student student;
}