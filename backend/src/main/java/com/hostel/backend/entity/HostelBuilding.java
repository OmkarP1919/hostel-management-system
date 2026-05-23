package com.hostel.backend.entity;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "hostel_buildings")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HostelBuilding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(unique = true)

    private String hostelName;

    private String hostelType;

    private Integer totalFloors;

    private String description;
}