package com.hostel.backend.exception;

import com.hostel.backend.dto.ApiResponse;
import com.hostel.backend.exception.EmailAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.hostel.backend.exception.InvalidCredentialsException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidationException(
            MethodArgumentNotValidException ex
    ) {

        String errorMessage = ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        ApiResponse<Object> response = new ApiResponse<>(
                false,
                errorMessage,
                null
        );

        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
        public ResponseEntity<ApiResponse<Object>>
        handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {

    ApiResponse<Object> response = new ApiResponse<>(
            false,
            ex.getMessage(),
            null
    );

    return new ResponseEntity<>(
            response,
            HttpStatus.BAD_REQUEST
    );
}

@ExceptionHandler(InvalidCredentialsException.class)
public ResponseEntity<ApiResponse<Object>>
handleInvalidCredentialsException(
        InvalidCredentialsException ex
) {

    ApiResponse<Object> response = new ApiResponse<>(
            false,
            ex.getMessage(),
            null
    );

    return new ResponseEntity<>(
            response,
            HttpStatus.UNAUTHORIZED
    );
}

}

