package com.hostel.backend.service;

import com.hostel.backend.dto.RoomRequestDto;
import com.hostel.backend.dto.RoomResponseDto;

import com.hostel.backend.entity.Room;

import com.hostel.backend.exception.
RoomAlreadyExistsException;

import com.hostel.backend.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public RoomResponseDto createRoom(
            RoomRequestDto requestDto
    ) {

        if (roomRepository.existsByRoomNumber(
                requestDto.getRoomNumber()
        )) {

            throw new RoomAlreadyExistsException(
                    "Room already exists"
            );
        }

        Room room = new Room();

        room.setRoomNumber(
                requestDto.getRoomNumber()
        );

        room.setCapacity(
                requestDto.getCapacity()
        );

        room.setOccupiedBeds(0);

        room.setBuildingName(
                requestDto.getBuildingName()
        );

        room.setFloorNumber(
                requestDto.getFloorNumber()
        );

        room.setCategory(
                requestDto.getCategory()
        );

        room.setAcEnabled(
                requestDto.getAcEnabled()
        );

        room.setStatus(
                requestDto.getStatus()
        );

        Room savedRoom =
                roomRepository.save(room);

        return mapToResponseDto(savedRoom);
    }

    public List<RoomResponseDto> getAllRooms() {

        return roomRepository.findAll()

                .stream()

                .map(this::mapToResponseDto)

                .collect(Collectors.toList());
    }

    private RoomResponseDto mapToResponseDto(
            Room room
    ) {

        return new RoomResponseDto(

                room.getId(),

                room.getRoomNumber(),

                room.getCapacity(),

                room.getOccupiedBeds(),

                room.getBuildingName(),

                room.getFloorNumber(),

                room.getCategory(),

                room.getAcEnabled(),

                room.getStatus()
        );
    }
}