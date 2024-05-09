package com.example.spring.service;

import java.util.Optional;
import java.util.UUID;

import javax.management.RuntimeErrorException;
import javax.swing.text.html.Option;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.spring.dto.StudentRequestDTO;
import com.example.spring.dto.StudentResponseDTO;
import com.example.spring.mapper.StudentMapper;
import com.example.spring.model.Student;
import com.example.spring.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private StudentMapper studentMapper;

    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO) {
        
        StudentResponseDTO studentResponseDTO = StudentMapper.INSTANCE.toResponseDTO(studentRequestDTO);
        studentResponseDTO.setStatus("Pending");
        studentResponseDTO.setId(UUID.randomUUID());

        Student student = StudentMapper.INSTANCE.toEntity(studentResponseDTO);
        studentRepository.save(student);
        return studentResponseDTO;
        
    }

    public Optional<StudentResponseDTO> readStudent(UUID id) {
        
        return studentRepository.findById(id)
        .map(student -> studentMapper.toStudentResponseDTO(student));
    }

    public StudentResponseDTO getStudent(UUID id) {

        Optional<Student> studentOptional = studentRepository.findById(id);
        StudentResponseDTO studentResponseDTO = null;

        if (studentOptional.isPresent()) {
            studentResponseDTO = new StudentResponseDTO();
            Student student = studentOptional.get();

            //mapping
            studentResponseDTO = studentMapper.toStudentResponseDTO(student);
        }
        
        return studentResponseDTO;

    }

    public boolean isDataValid(StudentRequestDTO studentRequestDTO) {

        String firstName = studentRequestDTO.getFirstName();
        String ssn = studentRequestDTO.getSsn();
        return (StringUtils.hasLength(ssn) && StringUtils.hasLength(firstName));
    }

    public void updateStudent(UUID id, StudentRequestDTO studentRequestDTO) {
        
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isEmpty()) {

            throw new RuntimeException("Student was not found with the given Id: " + id);
        }
        Student student = studentOptional.get();

        //mapping
        student.setAge(studentRequestDTO.getAge());
        student.setFirstName(studentRequestDTO.getFirstName());
        student.setLastName(studentRequestDTO.getLastName());
        student.setSsn(studentRequestDTO.getSsn());

        studentRepository.save(student);
        
        
    }

    public boolean doesStudentExist(UUID id) {
        
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.isPresent();

    }

    public void deleteStudent(UUID id) {

        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isEmpty()) {

            throw new RuntimeException("Student was not found with the given Id: " + id);
        }
        studentRepository.deleteById(id);
    }

    public boolean doesStudentExistbyPII(String ssn) {

        Optional<Student> studentOptional = studentRepository.findByssn(ssn);
        return studentOptional.isPresent();

    }
}
