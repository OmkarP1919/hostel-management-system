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
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private StudentRepository studentRepository;

    public ComplaintResponseDto createComplaint(

            ComplaintRequestDto requestDto
    ) {

        Student student =
                studentRepository.findById(
                        requestDto.getStudentId()
                ).orElseThrow(() ->
                        new RuntimeException(
                                "Student not found"
                        )
                );

        Complaint complaint =
                new Complaint();

        complaint.setTitle(
                requestDto.getTitle()
        );

        complaint.setDescription(
                requestDto.getDescription()
        );

        complaint.setCategory(
                requestDto.getCategory()
        );

        complaint.setStatus(
                ComplaintStatus.OPEN
        );

        complaint.setCreatedAt(
                LocalDateTime.now()
        );

        complaint.setStudent(student);

        Complaint savedComplaint =
                complaintRepository.save(
                        complaint
                );

        return mapToResponseDto(savedComplaint);
    }

    public List<ComplaintResponseDto>
    getAllComplaints() {

        return complaintRepository.findAll()

                .stream()

                .map(this::mapToResponseDto)

                .collect(Collectors.toList());
    }

    private ComplaintResponseDto
    mapToResponseDto(
            Complaint complaint
    ) {

        return new ComplaintResponseDto(

                complaint.getId(),

                complaint.getTitle(),

                complaint.getDescription(),

                complaint.getCategory(),

                complaint.getStatus(),

                complaint.getCreatedAt(),

                complaint.getResolvedAt(),

                complaint.getStudent()
                        .getFullName()
        );
    }
}