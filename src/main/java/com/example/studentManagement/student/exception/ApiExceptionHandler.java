package com.example.studentManagement.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ApiError> handleIdNotFound(StudentNotFoundException ex){
        ApiError error = new ApiError(404, "Not Found", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(StudentDuplicateEmailException.class)
    public ResponseEntity<ApiError> handleDuplicateEmail(StudentDuplicateEmailException ex){
        ApiError error = new ApiError(409, "Conflict", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(StudentEmailNotFoundException.class)
    public ResponseEntity<ApiError> handleEmailNotFound(StudentEmailNotFoundException ex){
        ApiError error = new ApiError(404, "Not Found", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
