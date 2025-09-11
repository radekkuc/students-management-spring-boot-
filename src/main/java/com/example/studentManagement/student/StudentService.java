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

    public Optional<Student> getStudentByEmail(String email){
        return studentRepository.getStudentByEmail(email);
    }

    public void removeStudentByIndex(Integer index){
        if(studentRepository.getStudentByIndex(index).isEmpty()){
            throw new RuntimeException("Student with given index doesnt exist");
        }
        studentRepository.delete(studentRepository.getStudentByIndex(index).get());
    }

    public void insertStudent(Student student){
        if(studentRepository.getStudentByEmail(student.getEmail()).isPresent()){
            throw new RuntimeException("Student with the same email exists, choose different email");
        }
        studentRepository.save(student);
    }
}
