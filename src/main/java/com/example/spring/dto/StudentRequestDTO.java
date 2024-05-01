package com.example.spring.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import jakarta.annotation.PostConstruct;
import java.util.Objects;

public class StudentRequestDTO {
    
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String ssn;
    @NotNull@Positive
    private int age;

    public StudentRequestDTO() {
    }

    public StudentRequestDTO(String firstName, String lastName, String ssn, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return this.ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentRequestDTO firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public StudentRequestDTO lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public StudentRequestDTO ssn(String ssn) {
        setSsn(ssn);
        return this;
    }

    public StudentRequestDTO age(int age) {
        setAge(age);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StudentRequestDTO)) {
            return false;
        }
        StudentRequestDTO studentRequestDTO = (StudentRequestDTO) o;
        return Objects.equals(firstName, studentRequestDTO.firstName) && Objects.equals(lastName, studentRequestDTO.lastName) && Objects.equals(ssn, studentRequestDTO.ssn) && age == studentRequestDTO.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, ssn, age);
    }

    @Override
    public String toString() {
        return "{" +
            " firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", ssn='" + getSsn() + "'" +
            ", age='" + getAge() + "'" +
            "}";
    }

}
