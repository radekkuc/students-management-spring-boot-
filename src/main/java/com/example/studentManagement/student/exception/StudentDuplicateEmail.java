package com.example.studentManagement.student.exception;

public class StudentDuplicateEmail extends RuntimeException {
    public StudentDuplicateEmail(String email){
        super("Student with given email already exists: " + email);
    }



}
