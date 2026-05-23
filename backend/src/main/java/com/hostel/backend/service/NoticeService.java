package com.hostel.backend.service;

import com.hostel.backend.dto.*;

import com.hostel.backend.entity.Notice;

import com.hostel.backend.repository.
NoticeRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    public NoticeResponseDto createNotice(

            NoticeRequestDto requestDto
    ) {

        Notice notice = new Notice();

        notice.setTitle(
                requestDto.getTitle()
        );

        notice.setContent(
                requestDto.getContent()
        );

        notice.setImportant(
                requestDto.getImportant()
        );

        notice.setCreatedAt(
                LocalDateTime.now()
        );

        Notice savedNotice =
                noticeRepository.save(notice);

        return mapToResponseDto(savedNotice);
    }

    public List<NoticeResponseDto>
    getAllNotices() {

        return noticeRepository.findAll()

                .stream()

                .map(this::mapToResponseDto)

                .collect(Collectors.toList());
    }

    private NoticeResponseDto
    mapToResponseDto(
            Notice notice
    ) {

        return new NoticeResponseDto(

                notice.getId(),

                notice.getTitle(),

                notice.getContent(),

                notice.getImportant(),

                notice.getCreatedAt()
        );
    }
}