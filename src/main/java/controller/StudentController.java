package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}