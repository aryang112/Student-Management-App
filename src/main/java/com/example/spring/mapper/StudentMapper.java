package com.example.spring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.spring.dto.StudentRequestDTO;
import com.example.spring.dto.StudentResponseDTO;
import com.example.spring.model.Student;


@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentResponseDTO toResponseDTO(StudentRequestDTO studentRequestDTO);
    Student toEntity(StudentResponseDTO studentResponseDTO);

    
}
