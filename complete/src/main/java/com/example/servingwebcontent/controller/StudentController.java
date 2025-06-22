package com.example.servingwebcontent.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.servingwebcontent.model.Student;
import com.example.servingwebcontent.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }


    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAll();
    }

 
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.add(student);
    }

   
    @PutMapping("/{id}")
    public boolean updateStudent(@PathVariable String id, @RequestBody Student student) {
        return service.update(id, student.getFullname(), student.getMajor());
    }


    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable String id) {
        return service.delete(id);
    }
}
