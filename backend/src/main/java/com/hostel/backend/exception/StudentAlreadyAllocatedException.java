package com.hostel.backend.exception;

public class StudentAlreadyAllocatedException
        extends RuntimeException {

    public StudentAlreadyAllocatedException(
            String message
    ) {

        super(message);
    }
}