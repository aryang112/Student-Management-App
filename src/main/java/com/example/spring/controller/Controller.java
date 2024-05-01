package com.example.spring.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.dto.StudentRequestDTO;
import com.example.spring.dto.StudentResponseDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class Controller {

    @GetMapping("/healthCheck")
    public ResponseEntity<?> healthcheck() {
        return ResponseEntity.ok().build();

    }

    @PostMapping(value = "/createStudent",
    produces = {"application/json"})
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO studentRequestDTO) {        
        //StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        
        return new ResponseEntity<StudentResponseDTO>(HttpStatus.CREATED);
    }
    
    
}
