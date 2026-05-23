package com.hostel.backend.service;

import com.hostel.backend.dto.*;

import com.hostel.backend.entity.*;

import com.hostel.backend.repository.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    public StudentResponseDto createStudent(

            StudentRequestDto requestDto
    ) {

        User user =
                userRepository.findById(
                        requestDto.getUserId()
                ).orElseThrow(() ->
                        new RuntimeException(
                                "User not found"
                        )
                );

        Student student = new Student();

        student.setFullName(
                requestDto.getFullName()
        );

        student.setAdmissionNumber(
                requestDto.getAdmissionNumber()
        );

        student.setBranch(
                requestDto.getBranch()
        );

        student.setAcademicYear(
                requestDto.getAcademicYear()
        );

        student.setGender(
                requestDto.getGender()
        );

        student.setPhoneNumber(
                requestDto.getPhoneNumber()
        );

        student.setGuardianName(
                requestDto.getGuardianName()
        );

        student.setGuardianPhone(
                requestDto.getGuardianPhone()
        );

        student.setAddress(
                requestDto.getAddress()
        );

        student.setUser(user);

        Student savedStudent =
                studentRepository.save(student);

        return mapToResponseDto(savedStudent);
    }

    public List<StudentResponseDto>
    getAllStudents() {

        return studentRepository.findAll()

                .stream()

                .map(this::mapToResponseDto)

                .collect(Collectors.toList());
    }

    public StudentPageResponseDto
searchStudents(

        String keyword,

        int page,

        int size
) {

    Pageable pageable =

            PageRequest.of(page, size);

    Page<Student> studentPage =

            studentRepository
                    .findByFullNameContainingIgnoreCase(

                            keyword,

                            pageable
                    );

    List<StudentResponseDto> students =

            studentPage.getContent()

                    .stream()

                    .map(this::mapToResponseDto)

                    .toList();

    return new StudentPageResponseDto(

            students,

            studentPage.getNumber(),

            studentPage.getTotalPages(),

            studentPage.getTotalElements()
    );
}

    private StudentResponseDto
    mapToResponseDto(Student student) {

        return new StudentResponseDto(

                student.getId(),

                student.getFullName(),

                student.getAdmissionNumber(),

                student.getBranch(),

                student.getAcademicYear(),

                student.getGender(),

                student.getPhoneNumber(),

                student.getGuardianName(),

                student.getGuardianPhone(),

                student.getAddress(),

                student.getUser().getEmail()
        );
    }
}