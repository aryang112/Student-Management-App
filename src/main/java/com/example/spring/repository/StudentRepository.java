package com.example.spring.repository;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.model.Student;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    Optional<Student> findByssn(String ssn);
    
    
}
