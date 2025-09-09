package com.example.studentManagement.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentsByEmail(String email){
        return studentRepository.getStudentsByEmail(email);
    }

    public void insertStudent(Student student){
        if(studentRepository.getStudentsByEmail(student.getEmail()).isEmpty()){
            throw new RuntimeException("Student with the same email exists, choose different email");
        }
        studentRepository.save(student);
    }
}
