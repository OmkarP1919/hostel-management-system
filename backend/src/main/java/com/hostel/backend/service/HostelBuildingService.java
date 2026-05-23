package com.hostel.backend.service;

import com.hostel.backend.dto.*;

import com.hostel.backend.entity.
HostelBuilding;

import com.hostel.backend.repository.
HostelBuildingRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HostelBuildingService {

    @Autowired
    private HostelBuildingRepository
            hostelBuildingRepository;

    public HostelBuildingResponseDto
    createHostelBuilding(

            HostelBuildingRequestDto requestDto
    ) {

        if (
                hostelBuildingRepository
                        .existsByHostelName(

                                requestDto.getHostelName()
                        )
        ) {

            throw new RuntimeException(
                    "Hostel building already exists"
            );
        }

        HostelBuilding hostel =
                new HostelBuilding();

        hostel.setHostelName(
                requestDto.getHostelName()
        );

        hostel.setHostelType(
                requestDto.getHostelType()
        );

        hostel.setTotalFloors(
                requestDto.getTotalFloors()
        );

        hostel.setDescription(
                requestDto.getDescription()
        );

        HostelBuilding savedHostel =

                hostelBuildingRepository
                        .save(hostel);

        return mapToResponseDto(savedHostel);
    }

    public List<HostelBuildingResponseDto>
    getAllHostels() {

        return hostelBuildingRepository.findAll()

                .stream()

                .map(this::mapToResponseDto)

                .collect(Collectors.toList());
    }

    private HostelBuildingResponseDto
    mapToResponseDto(
            HostelBuilding hostel
    ) {

        return new HostelBuildingResponseDto(

                hostel.getId(),

                hostel.getHostelName(),

                hostel.getHostelType(),

                hostel.getTotalFloors(),

                hostel.getDescription()
        );
    }
}