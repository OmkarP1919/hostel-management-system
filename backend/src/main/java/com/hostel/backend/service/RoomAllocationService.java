package com.hostel.backend.service;

import com.hostel.backend.dto.*;

import com.hostel.backend.entity.*;

import com.hostel.backend.enums.*;

import com.hostel.backend.exception.*;

import com.hostel.backend.repository.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RoomAllocationService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomAllocationRepository
            allocationRepository;

    public AllocationResponseDto allocateRoom(

            AllocationRequestDto requestDto
    ) {

        Student student =
                studentRepository.findById(
                        requestDto.getStudentId()
                ).orElseThrow(() ->
                        new RuntimeException(
                                "Student not found"
                        )
                );

        Room room =
                roomRepository.findById(
                        requestDto.getRoomId()
                ).orElseThrow(() ->
                        new RuntimeException(
                                "Room not found"
                        )
                );

        allocationRepository
                .findByStudentAndStatus(

                        student,

                        AllocationStatus.ACTIVE
                )
                .ifPresent(allocation -> {

                    throw new
                            StudentAlreadyAllocatedException(

                            "Student already has active room allocation"
                    );
                });

        if (
                room.getOccupiedBeds()
                        >= room.getCapacity()
        ) {

            throw new RoomFullException(
                    "Room is already full"
            );
        }

        RoomAllocation allocation =
                new RoomAllocation();

        allocation.setStudent(student);

        allocation.setRoom(room);

        allocation.setAllocationDate(
                LocalDate.now()
        );

        allocation.setStatus(
                AllocationStatus.ACTIVE
        );

        allocation.setRemarks(
                requestDto.getRemarks()
        );

        RoomAllocation savedAllocation =
                allocationRepository.save(allocation);

        room.setOccupiedBeds(
                room.getOccupiedBeds() + 1
        );

        if (
                room.getOccupiedBeds()
                        .equals(room.getCapacity())
        ) {

            room.setStatus(RoomStatus.FULL);
        }

        roomRepository.save(room);

        return new AllocationResponseDto(

                savedAllocation.getId(),

                student.getFullName(),

                room.getRoomNumber(),

                savedAllocation.getAllocationDate(),

                savedAllocation.getStatus(),

                savedAllocation.getRemarks()
        );
    }

    public AllocationResponseDto vacateRoom(

        VacateRequestDto requestDto
) {

    RoomAllocation allocation =

            allocationRepository

                    .findByStudentIdAndStatus(

                            requestDto.getStudentId(),

                            AllocationStatus.ACTIVE
                    )

                    .orElseThrow(() ->

                            new RuntimeException(

                                    "No active room allocation found"
                            )
                    );

    allocation.setStatus(
            AllocationStatus.COMPLETED
    );

    allocation.setVacateDate(
            LocalDate.now()
    );

    allocation.setRemarks(
            requestDto.getRemarks()
    );

    Room room = allocation.getRoom();

    room.setOccupiedBeds(

            room.getOccupiedBeds() - 1
    );

    if (
            room.getOccupiedBeds()
                    < room.getCapacity()
    ) {

        room.setStatus(
                RoomStatus.AVAILABLE
        );
    }

    roomRepository.save(room);

    RoomAllocation updatedAllocation =

            allocationRepository.save(allocation);

    return new AllocationResponseDto(

            updatedAllocation.getId(),

            allocation.getStudent().getFullName(),

            room.getRoomNumber(),

            updatedAllocation.getAllocationDate(),

            updatedAllocation.getStatus(),

            updatedAllocation.getRemarks()
    );
}

public AllocationResponseDto transferRoom(

        TransferRequestDto requestDto
) {

    RoomAllocation currentAllocation =

            allocationRepository

                    .findByStudentIdAndStatus(

                            requestDto.getStudentId(),

                            AllocationStatus.ACTIVE
                    )

                    .orElseThrow(() ->

                            new RuntimeException(

                                    "No active allocation found"
                            )
                    );

    Room oldRoom = currentAllocation.getRoom();

    Room newRoom = roomRepository.findById(

            requestDto.getNewRoomId()

    ).orElseThrow(() ->

            new RuntimeException(
                    "New room not found"
            )
    );

    if (
            newRoom.getOccupiedBeds()
                    >= newRoom.getCapacity()
    ) {

        throw new RoomFullException(
                "New room is already full"
        );
    }

    currentAllocation.setStatus(
            AllocationStatus.COMPLETED
    );

    currentAllocation.setVacateDate(
            LocalDate.now()
    );

    currentAllocation.setRemarks(
            "Transferred: " + requestDto.getRemarks()
    );

    allocationRepository.save(currentAllocation);

    oldRoom.setOccupiedBeds(
            oldRoom.getOccupiedBeds() - 1
    );

    oldRoom.setStatus(
            RoomStatus.AVAILABLE
    );

    roomRepository.save(oldRoom);

    RoomAllocation newAllocation =
            new RoomAllocation();

    newAllocation.setStudent(
            currentAllocation.getStudent()
    );

    newAllocation.setRoom(newRoom);

    newAllocation.setAllocationDate(
            LocalDate.now()
    );

    newAllocation.setStatus(
            AllocationStatus.ACTIVE
    );

    newAllocation.setRemarks(
            requestDto.getRemarks()
    );

    RoomAllocation savedAllocation =
            allocationRepository.save(newAllocation);

    newRoom.setOccupiedBeds(
            newRoom.getOccupiedBeds() + 1
    );

    if (
            newRoom.getOccupiedBeds()
                    .equals(newRoom.getCapacity())
    ) {

        newRoom.setStatus(RoomStatus.FULL);
    }

    roomRepository.save(newRoom);

    return new AllocationResponseDto(

            savedAllocation.getId(),

            savedAllocation.getStudent()
                    .getFullName(),

            newRoom.getRoomNumber(),

            savedAllocation.getAllocationDate(),

            savedAllocation.getStatus(),

            savedAllocation.getRemarks()
    );
}
}