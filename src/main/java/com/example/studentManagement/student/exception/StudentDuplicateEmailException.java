package com.example.studentManagement.student.exception;

public class StudentDuplicateEmailException extends RuntimeException {
    public StudentDuplicateEmailException(String email){
        super("Student with given email already exists: " + email);
    }
}
