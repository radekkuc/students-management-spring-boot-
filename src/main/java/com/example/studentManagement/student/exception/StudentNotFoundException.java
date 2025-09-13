package com.example.studentManagement.student.exception;

import com.example.studentManagement.student.Student;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Integer id){
        super("Student with given index not found: " + id);
    }
}
