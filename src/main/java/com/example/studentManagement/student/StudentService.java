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

    public Optional<Student> getStudentByIndex(Integer index){
//        if(studentRepository.getStudentByIndex(index).isEmpty()){
//            throw new RuntimeException("Student with given index doesnt exist");
//        }
        return studentRepository.getStudentByIndex(index);
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

    public void changeStudentData(Integer index, Student student){
        Student student_db = studentRepository.getStudentByIndex(index)
                .orElseThrow(() -> new RuntimeException("Student with given index doesnt exist"));

        student_db.setAge(student.getAge());
        student_db.setEmail(student.getEmail());
        student_db.setName(student.getName());

        studentRepository.save(student_db);
    }

}
