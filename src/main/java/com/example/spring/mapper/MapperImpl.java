package com.example.spring.mapper;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.spring.dto.StudentRequestDTO;
import com.example.spring.model.Student;
import com.example.spring.repository.StudentRepository;

public class MapperImpl {

    @Autowired
    StudentRepository studentRepository;

    public Student updateStudentfromRequest(UUID Id, StudentRequestDTO studentRequestDTO) {


        return null;
    }
    
}
