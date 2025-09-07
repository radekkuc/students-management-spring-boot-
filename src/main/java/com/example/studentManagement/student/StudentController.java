package com.example.studentManagement.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/students")
public class StudentController {
    // Adding student
    @GetMapping
    public List<Student> getStudents(){
        return List.of(
                new Student(412796 ,"Radoslaw Kuc", 23, "radekkuc5@gmail.com")
        );
    }
    // Checking chosen student

    // Deleting student

    // Updating student




}
