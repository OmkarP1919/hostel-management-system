package com.hostel.backend.service;

import com.hostel.backend.dto.*;

import com.hostel.backend.entity.*;

import com.hostel.backend.repository.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeeStructureService {

    @Autowired
    private FeeStructureRepository
            feeStructureRepository;

    @Autowired
    private HostelBuildingRepository
            hostelBuildingRepository;

    public FeeStructureResponseDto
    createFeeStructure(

            FeeStructureRequestDto requestDto
    ) {

        HostelBuilding hostel =

                hostelBuildingRepository.findById(

                        requestDto.getHostelBuildingId()

                ).orElseThrow(() ->

                        new RuntimeException(
                                "Hostel not found"
                        )
                );

        FeeStructure fee =
                new FeeStructure();

        fee.setHostelBuilding(hostel);

        fee.setAcademicYear(
                requestDto.getAcademicYear()
        );

        fee.setAnnualHostelFee(
                requestDto.getAnnualHostelFee()
        );

        fee.setInternetCharges(
                requestDto.getInternetCharges()
        );

        fee.setWashingCharges(
                requestDto.getWashingCharges()
        );

        fee.setIroningCharges(
                requestDto.getIroningCharges()
        );

        fee.setRefundableDeposit(
                requestDto.getRefundableDeposit()
        );

        fee.setActive(
                requestDto.getActive()
        );

        double total =

                requestDto.getAnnualHostelFee()

                        + requestDto.getInternetCharges()

                        + requestDto.getWashingCharges()

                        + requestDto.getIroningCharges()

                        + requestDto.getRefundableDeposit();

        fee.setTotalFees(total);

        FeeStructure savedFee =

                feeStructureRepository.save(fee);

        return mapToResponseDto(savedFee);
    }

    public List<FeeStructureResponseDto>
    getAllFeeStructures() {

        return feeStructureRepository.findAll()

                .stream()

                .map(this::mapToResponseDto)

                .collect(Collectors.toList());
    }

    private FeeStructureResponseDto
    mapToResponseDto(
            FeeStructure fee
    ) {

        return new FeeStructureResponseDto(

                fee.getId(),

                fee.getHostelBuilding()
                        .getHostelName(),

                fee.getAcademicYear(),

                fee.getAnnualHostelFee(),

                fee.getInternetCharges(),

                fee.getWashingCharges(),

                fee.getIroningCharges(),

                fee.getRefundableDeposit(),

                fee.getTotalFees(),

                fee.getActive()
        );
    }
}