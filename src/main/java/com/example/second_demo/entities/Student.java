package com.example.second_demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate dob;
    private String email;
    private Integer age ;

//    @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
//    private Collection<Course> courses = new ArrayList<>();


    public Student() {
    }

    public Student(Long id, String name, LocalDate dob, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.age = age;
    }

    public Student(String name, LocalDate dob, String email, Integer age) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
