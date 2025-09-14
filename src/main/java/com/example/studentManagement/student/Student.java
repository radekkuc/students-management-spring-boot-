package com.example.studentManagement.student;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer studentIndex;
    private String name;
    private Integer age;
    private String email;

    public Student() {}

    public Student(Integer index, String name, Integer age, String email) {
        this.studentIndex = index;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Student(Integer index) {
        this.studentIndex = index;
    }

    public Integer getIndex() {
        return studentIndex;
    }

    public void setIndex(Integer index) {
        this.studentIndex = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "index=" + studentIndex +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
