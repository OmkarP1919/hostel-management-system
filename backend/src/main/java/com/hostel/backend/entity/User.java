package com.hostel.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;

    private String role;
}