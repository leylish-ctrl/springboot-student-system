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

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot";
    }

    @GetMapping("/info")
    public String info() {
        return "Student API is running";
    }

    @GetMapping("/status")
    public String status() {
        return "API is healthy";
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        students.removeIf(student -> student.getId().equals(id));
        return "Student deleted";
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setName(updatedStudent.getName());
                student.setEmail(updatedStudent.getEmail());
                return student;
            }
        }
        return null;
    }
}