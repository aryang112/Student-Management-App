package com.example.spring.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Objects;

@Entity
public class Student {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    
    private String firstName;
    private String lastName;
    private String email;
    private String status;
    private String ssn;
    private int age;

    public Student() {
    }

    public Student(UUID Id, String firstName, String lastName, String email, String status, String ssn, int age) {
        this.Id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
        this.ssn = ssn;
        this.age = age;
    }

    public UUID getId() {
        return this.Id;
    }

    public void setId(UUID Id) {
        this.Id = Id;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Student Id(UUID Id) {
        setId(Id);
        return this;
    }

    public Student firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Student lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public Student email(String email) {
        setEmail(email);
        return this;
    }

    public Student status(String status) {
        setStatus(status);
        return this;
    }

    public Student ssn(String ssn) {
        setSsn(ssn);
        return this;
    }

    public Student age(int age) {
        setAge(age);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(Id, student.Id) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(email, student.email) && Objects.equals(status, student.status) && Objects.equals(ssn, student.ssn) && age == student.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, firstName, lastName, email, status, ssn, age);
    }

    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", status='" + getStatus() + "'" +
            ", ssn='" + getSsn() + "'" +
            ", age='" + getAge() + "'" +
            "}";
    }
    
}
