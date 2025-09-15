package com.example.studentManagement.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/students")
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

    @GetMapping("/email/{email}")
    public Student getStudentByEmail(@PathVariable String email){
        return studentService.getStudentByEmail(email);
    }

    @GetMapping("/index/{index}")
    public Student getStudentByIndex(@PathVariable Integer index){
        return studentService.getStudentByIndex(index);
    }

    @DeleteMapping("/{index}")
    public void removeStudentByIndex(@PathVariable Integer index){
        studentService.removeStudentByIndex(index);
    }

    @PostMapping
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }

    @PutMapping("/{index}")
    public void changeStudentData(@PathVariable Integer index, @RequestBody Student student){
        studentService.changeAllStudentData(index, student);
    }

    @PatchMapping("/{index}")
    public void updateStudentData(@PathVariable Integer index, @RequestBody Map<String, Object> updates){
        studentService.updateStudentData(index, updates);
    }
}

