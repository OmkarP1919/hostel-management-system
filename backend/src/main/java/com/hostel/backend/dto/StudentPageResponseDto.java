package com.hostel.backend.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentPageResponseDto {

    private List<StudentResponseDto> students;

    private int currentPage;

    private int totalPages;

    private long totalElements;
}