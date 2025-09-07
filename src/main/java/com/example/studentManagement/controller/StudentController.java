package com.example.studentManagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    // Adding student
    @GetMapping
    public List<String> hello(){
        return List.of("Hello", "World", "Whatever");
    }
    // Checking chosen student

    // Deleting student

    // Updating student




}
