package com.example.studentManagement.student.exception;

public class StudentEmailNotFoundException extends RuntimeException {
    public StudentEmailNotFoundException(String email){
        super("Student with given email not found: " + email);
    }

}
