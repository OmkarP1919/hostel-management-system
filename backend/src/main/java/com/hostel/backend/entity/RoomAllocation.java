package com.hostel.backend.entity;

import com.hostel.backend.enums.AllocationStatus;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "room_allocations")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne

    @JoinColumn(name = "student_id")

    private Student student;

    @ManyToOne

    @JoinColumn(name = "room_id")

    private Room room;

    private LocalDate allocationDate;

    private LocalDate vacateDate;

    @Enumerated(EnumType.STRING)

    private AllocationStatus status;

    private String remarks;
}