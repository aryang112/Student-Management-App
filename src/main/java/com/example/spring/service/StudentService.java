package com.example.spring.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.dto.StudentRequestDTO;
import com.example.spring.dto.StudentResponseDTO;
import com.example.spring.mapper.StudentMapper;
import com.example.spring.model.Student;
import com.example.spring.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO) {
        
        StudentResponseDTO studentResponseDTO = StudentMapper.INSTANCE.toResponseDTO(studentRequestDTO);
        studentResponseDTO.setStatus("Pending");
        studentResponseDTO.setId(UUID.randomUUID());

        Student student = StudentMapper.INSTANCE.toEntity(studentResponseDTO);
        studentRepository.save(student);
        return studentResponseDTO;
        
    }

    public Optional<Student> readStudent(UUID Id) {
        

        return studentRepository.findById(Id);
        
    }
    
}
