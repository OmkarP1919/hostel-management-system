package com.hostel.backend.service;

import com.hostel.backend.dto.
DashboardResponseDto;

import com.hostel.backend.entity.Room;

import com.hostel.backend.enums.*;

import com.hostel.backend.repository.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomAllocationRepository
            allocationRepository;

    public DashboardResponseDto
    getDashboardAnalytics() {

        long totalStudents =
                studentRepository.count();

        long totalRooms =
                roomRepository.count();

        long activeAllocations =
                allocationRepository.countByStatus(

                        AllocationStatus.ACTIVE
                );

        long availableRooms =
                roomRepository.countByStatus(

                        RoomStatus.AVAILABLE
                );

        long occupiedRooms =
                roomRepository.countByStatus(

                        RoomStatus.FULL
                );

        List<Room> rooms =
                roomRepository.findAll();

        int totalBeds = rooms.stream()

                .mapToInt(Room::getCapacity)

                .sum();

        int occupiedBeds = rooms.stream()

                .mapToInt(Room::getOccupiedBeds)

                .sum();

        int availableBeds =
                totalBeds - occupiedBeds;

        double occupancyPercentage = 0;

        if (totalBeds > 0) {

            occupancyPercentage =

                    ((double) occupiedBeds
                            / totalBeds) * 100;
        }

        return new DashboardResponseDto(

                totalStudents,

                totalRooms,

                activeAllocations,

                availableRooms,

                occupiedRooms,

                totalBeds,

                occupiedBeds,

                availableBeds,

                occupancyPercentage
        );
    }
}