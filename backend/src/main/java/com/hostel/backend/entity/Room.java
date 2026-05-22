package com.hostel.backend.entity;

import com.hostel.backend.enums.RoomStatus;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "rooms")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(unique = true)

    private String roomNumber;

    private Integer capacity;

    private Integer occupiedBeds = 0;

    private String buildingName;

    private Integer floorNumber;

    private String category;

    private Boolean acEnabled;

    @Enumerated(EnumType.STRING)

    private RoomStatus status;
}