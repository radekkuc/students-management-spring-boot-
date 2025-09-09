package com.example.studentManagement.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/students")
public class StudentController {
    private final StudentService studentService;

    // If we have only one constructor then we don't have to use autowired but if there are many constructors then
    // we must specify for spring which one to use to inject dependencies
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }





}
