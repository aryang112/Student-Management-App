package com.example.spring.controller;

import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.dto.StudentRequestDTO;
import com.example.spring.dto.StudentResponseDTO;
import com.example.spring.repository.StudentRepository;
import com.example.spring.service.StudentService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class Controller {

    @Autowired
    private StudentService studentService;

    @GetMapping("/healthCheck")
    public ResponseEntity<?> healthcheck() {
        return ResponseEntity.ok().build();

    }

    @PostMapping(value = "/createStudent",
    produces = {"application/json"})
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO studentRequestDTO) {        
        
        StudentResponseDTO studentResponseDTO = studentService.createStudent(studentRequestDTO);

        return ResponseEntity.ok(studentResponseDTO);
    }

    @GetMapping(value = "/readStudent/{Id}",
    produces = ("application/json"))
    public ResponseEntity<StudentResponseDTO> readStudent(@PathVariable UUID Id) {
        Optional<StudentResponseDTO> optionalStudentDTO = studentService.readStudent(Id);
        if (optionalStudentDTO.isPresent()) {
            return ResponseEntity.ok().body(optionalStudentDTO.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    
}
