package com.hostel.backend.service;

import com.hostel.backend.dto.*;

import com.hostel.backend.entity.*;

import com.hostel.backend.enums.*;

import com.hostel.backend.repository.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentFeeService {

    @Autowired
    private StudentFeeRepository
            studentFeeRepository;

    @Autowired
    private StudentRepository
            studentRepository;

    @Autowired
    private FeeStructureRepository
            feeStructureRepository;

    public StudentFeeResponseDto
    generateStudentFee(

            StudentFeeRequestDto requestDto
    ) {

        Student student =

                studentRepository.findById(

                        requestDto.getStudentId()

                ).orElseThrow(() ->

                        new RuntimeException(
                                "Student not found"
                        )
                );

        FeeStructure feeStructure =

                feeStructureRepository.findById(

                        requestDto.getFeeStructureId()

                ).orElseThrow(() ->

                        new RuntimeException(
                                "Fee structure not found"
                        )
                );

        StudentFee studentFee =
                new StudentFee();

        studentFee.setStudent(student);

        studentFee.setFeeStructure(
                feeStructure
        );

        studentFee.setTotalAmount(
                feeStructure.getTotalFees()
        );

        studentFee.setPaidAmount(0.0);

        studentFee.setDueAmount(
                feeStructure.getTotalFees()
        );

        studentFee.setPaymentStatus(
                PaymentStatus.PENDING
        );

        studentFee.setGeneratedAt(
                LocalDateTime.now()
        );

        StudentFee savedFee =

                studentFeeRepository.save(
                        studentFee
                );

        return mapToResponseDto(savedFee);
    }

    public List<StudentFeeResponseDto>
    getAllStudentFees() {

        return studentFeeRepository.findAll()

                .stream()

                .map(this::mapToResponseDto)

                .collect(Collectors.toList());
    }

    private StudentFeeResponseDto
    mapToResponseDto(
            StudentFee fee
    ) {

        return new StudentFeeResponseDto(

                fee.getId(),

                fee.getStudent()
                        .getFullName(),

                fee.getFeeStructure()
                        .getHostelBuilding()
                        .getHostelName(),

                fee.getTotalAmount(),

                fee.getPaidAmount(),

                fee.getDueAmount(),

                fee.getPaymentStatus()
        );
    }
}