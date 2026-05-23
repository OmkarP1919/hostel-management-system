package com.hostel.backend.repository;

import com.hostel.backend.entity.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    boolean existsByAdmissionNumber(
            String admissionNumber
    );

    Page<Student>
    findByFullNameContainingIgnoreCase(

            String fullName,

            Pageable pageable
    );

    Page<Student>
    findByBranchIgnoreCase(

            String branch,

            Pageable pageable
    );
}