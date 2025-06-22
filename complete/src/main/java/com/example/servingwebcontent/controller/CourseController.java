package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Course;
import com.example.servingwebcontent.service.CourseService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    
    @GetMapping
    public List<Course> getAllCourses() {
        return service.getAll();
    }

 
    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return service.add(course);
    }

  
    @PutMapping("/{id}")
    public boolean updateCourse(@PathVariable String id, @RequestBody Course course) {
        return service.update(id, course.getCredits(), course.getStatus());
    }

    @DeleteMapping("/{id}")
    public boolean deleteCourse(@PathVariable String id) {
        return service.delete(id);
    }
}
