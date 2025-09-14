package com.example.studentManagement.student;

import com.example.studentManagement.student.exception.StudentDuplicateEmailException;
import com.example.studentManagement.student.exception.StudentNotFoundException;
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
                .orElseThrow(() ->  new StudentDuplicateEmailException(email));
    }

    public Student getStudentByIndex(Integer index){
        return studentRepository.getStudentByIndex(index)
                .orElseThrow(() -> new StudentNotFoundException(index));
    }

    public void removeStudentByIndex(Integer index){
        studentRepository.delete(studentRepository.getStudentByIndex(index)
                .orElseThrow(() -> new StudentNotFoundException(index)));
    }

    public void insertStudent(Student student){
        if(studentRepository.getStudentByEmail(student.getEmail()).isPresent()){
            throw new StudentDuplicateEmailException(student.getEmail());
        }
        studentRepository.save(student);
    }

    public void changeAllStudentData(Integer index, Student student){
        Student student_db = studentRepository.getStudentByIndex(index)
                .orElseThrow(() -> new StudentNotFoundException(index));

        student_db.setAge(student.getAge());
        student_db.setEmail(student.getEmail());
        student_db.setName(student.getName());

        studentRepository.save(student_db);
    }

    public void updateStudentData(Integer index, Map<String, Object> update){
        Student student = studentRepository.getStudentByIndex(index)
                .orElseThrow(() -> new StudentNotFoundException(index));

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
