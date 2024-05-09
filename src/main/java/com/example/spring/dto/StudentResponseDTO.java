package com.example.spring.dto;

import java.util.UUID;

import com.example.spring.model.Student;

import java.util.Objects;

public class StudentResponseDTO {
    
    private UUID id;
    private String firstName;
    private String ssn;
    private String lastName;
    private int age;
    private String status;

    public StudentResponseDTO() {
    }

    public StudentResponseDTO(UUID id, String firstName, String ssn, String lastName, int age, String status) {
        this.id = id;
        this.firstName = firstName;
        this.ssn = ssn;
        this.lastName = lastName;
        this.age = age;
        this.status = status;
    }

    public StudentResponseDTO(Student student) {
        //TODO Auto-generated constructor stub
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSsn() {
        return this.ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StudentResponseDTO id(UUID id) {
        setId(id);
        return this;
    }

    public StudentResponseDTO firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public StudentResponseDTO ssn(String ssn) {
        setSsn(ssn);
        return this;
    }

    public StudentResponseDTO lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public StudentResponseDTO age(int age) {
        setAge(age);
        return this;
    }

    public StudentResponseDTO status(String status) {
        setStatus(status);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StudentResponseDTO)) {
            return false;
        }
        StudentResponseDTO studentResponseDTO = (StudentResponseDTO) o;
        return Objects.equals(id, studentResponseDTO.id) && Objects.equals(firstName, studentResponseDTO.firstName) && Objects.equals(ssn, studentResponseDTO.ssn) && Objects.equals(lastName, studentResponseDTO.lastName) && age == studentResponseDTO.age && Objects.equals(status, studentResponseDTO.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, ssn, lastName, age, status);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", ssn='" + getSsn() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", age='" + getAge() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
    
}
