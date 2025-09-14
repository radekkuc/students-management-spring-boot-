package com.example.studentManagement.student.exception;

public class StudentDuplicateIndexException extends RuntimeException{
    public StudentDuplicateIndexException(Integer student_index){
        super("Student with given index already exists: " + student_index);
    }
}
