package com.example.studentManagement.student;

import com.example.studentManagement.student.exception.StudentDuplicateEmailException;
import com.example.studentManagement.student.exception.StudentDuplicateIndexException;
import com.example.studentManagement.student.exception.StudentEmailNotFoundException;
import com.example.studentManagement.student.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
                .orElseThrow(() ->  new StudentEmailNotFoundException(email));
    }

    public Student getStudentByIndex(Integer index){
        return studentRepository.getStudentByStudentIndex(index)
                .orElseThrow(() -> new StudentNotFoundException(index));
    }

    public void removeStudentByIndex(Integer index){
        studentRepository.delete(studentRepository.getStudentByStudentIndex(index)
                .orElseThrow(() -> new StudentNotFoundException(index)));
    }

    public void insertStudent(Student student){
        if(studentRepository.getStudentByEmail(student.getEmail()).isPresent()){
            throw new StudentDuplicateEmailException(student.getEmail());
        }

        if(studentRepository.getStudentByStudentIndex(student.getIndex()).isPresent()){
            throw new StudentDuplicateIndexException(student.getIndex());
        }

        studentRepository.save(student);
    }

    public void changeAllStudentData(Integer index, Student student){
        Student student_db = studentRepository.getStudentByStudentIndex(index)
                .orElseThrow(() -> new StudentNotFoundException(index));

        student_db.setAge(student.getAge());
        student_db.setEmail(student.getEmail());
        student_db.setName(student.getName());

        studentRepository.save(student_db);
    }

    public void updateStudentData(Integer index, Map<String, Object> update){
        Student student = studentRepository.getStudentByStudentIndex(index)
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
