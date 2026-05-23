package com.hostel.backend.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NoticeResponseDto {

    private Long id;

    private String title;

    private String content;

    private Boolean important;

    private LocalDateTime createdAt;
}