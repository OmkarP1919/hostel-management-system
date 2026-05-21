package com.hostel.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ApiResponse<T> {

    private boolean success;

    private String message;

    private T data;
}