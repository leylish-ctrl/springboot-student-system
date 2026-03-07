package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1L, "Ali", "ali@example.com"));
        students.add(new Student(2L, "Ayse", "ayse@example.com"));
    }

    @GetMapping("/student")
    public Student getStudent() {
        return new Student(1L, "Ali", "ali@example.com");
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot";
    }

    @GetMapping("/info")
    public String info() {
        return "Student API is running";
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}