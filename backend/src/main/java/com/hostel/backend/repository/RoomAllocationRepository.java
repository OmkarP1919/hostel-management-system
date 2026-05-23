package com.hostel.backend.repository;

import com.hostel.backend.entity.RoomAllocation;
import com.hostel.backend.entity.Student;

import com.hostel.backend.enums.AllocationStatus;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomAllocationRepository
        extends JpaRepository<RoomAllocation, Long> {

    Optional<RoomAllocation>
    findByStudentAndStatus(

            Student student,

            AllocationStatus status
    );

    Optional<RoomAllocation>
findByStudentIdAndStatus(

        Long studentId,

        AllocationStatus status
);

long countByStatus(
        AllocationStatus status
);
}