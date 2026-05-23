package com.hostel.backend.repository;

import com.hostel.backend.entity.
FeeStructure;

import org.springframework.data.jpa.repository.
JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface FeeStructureRepository
        extends JpaRepository<
                FeeStructure,
                Long
        > {
}