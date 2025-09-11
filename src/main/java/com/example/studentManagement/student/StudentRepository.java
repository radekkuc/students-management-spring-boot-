package com.example.studentManagement.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.email = :email")
    public Optional<Student> getStudentByEmail(String email);

    public Optional<Student> getStudentByIndex(Integer index);

}
