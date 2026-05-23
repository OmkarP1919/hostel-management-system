package com.hostel.backend.repository;

import com.hostel.backend.entity.
StudentFee;

import org.springframework.data.jpa.repository.
JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentFeeRepository
        extends JpaRepository<
                StudentFee,
                Long
        > {
}