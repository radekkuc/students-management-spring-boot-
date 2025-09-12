package com.example.studentManagement.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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

    public Student getStudentByEmail(String email){
        return studentRepository.getStudentByEmail(email)
                .orElseThrow(() ->  new RuntimeException("Student with given email does not exist"));
    }

    public Student getStudentByIndex(Integer index){
        return studentRepository.getStudentByIndex(index)
                .orElseThrow(() -> new RuntimeException("Student with given index does not exist"));
    }

    public void removeStudentByIndex(Integer index){
        studentRepository.delete(studentRepository.getStudentByIndex(index)
                .orElseThrow(() -> new RuntimeException("Student with given index does not exist")));
    }

    public void insertStudent(Student student){
        if(studentRepository.getStudentByEmail(student.getEmail()).isPresent()){
            throw new RuntimeException("Student with the same email exists, choose different email");
        }
        studentRepository.save(student);
    }

    public void changeAllStudentData(Integer index, Student student){
        Student student_db = studentRepository.getStudentByIndex(index)
                .orElseThrow(() -> new RuntimeException("Student with given index does not exist"));

        student_db.setAge(student.getAge());
        student_db.setEmail(student.getEmail());
        student_db.setName(student.getName());

        studentRepository.save(student_db);
    }

    public void updateStudentData(Integer index, Map<String, Object> update){
        Student student = studentRepository.getStudentByIndex(index)
                .orElseThrow(() -> new RuntimeException("Student with provided index does not exist"));

        if(update.containsKey("name")){
            student.setName((String) update.get("name"));
        }
        if(update.containsKey("age")){
            student.setAge((Integer) update.get("age"));
        }
        if(update.containsKey("email")){
            student.setEmail((String) update.get("email"));
        }

        studentRepository.save(student);
    }
}
