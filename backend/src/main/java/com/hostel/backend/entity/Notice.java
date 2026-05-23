package com.hostel.backend.entity;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notices")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String title;

    @Column(length = 2000)

    private String content;

    private Boolean important;

    private LocalDateTime createdAt;
}