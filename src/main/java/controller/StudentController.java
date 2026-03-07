package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {
        return new Student(1L, "Ali", "ali@example.com");
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return List.of(
                new Student(1L, "Ali", "ali@example.com"),
                new Student(2L, "Ayse", "ayse@example.com")
        );
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot";
    }
}