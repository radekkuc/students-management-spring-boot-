package com.example.studentManagement.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents(){
        return List.of(
                new Student(412796 ,"Radoslaw Kuc", 23, "radekkuc5@gmail.com")
        );
    }

}
