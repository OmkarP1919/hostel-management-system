package com.hostel.backend.repository;

import com.hostel.backend.entity.
HostelBuilding;

import org.springframework.data.jpa.repository.
JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface HostelBuildingRepository
        extends JpaRepository<
                HostelBuilding,
                Long
        > {

    boolean existsByHostelName(
            String hostelName
    );
}