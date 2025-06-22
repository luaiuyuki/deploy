package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.Course;
import com.example.servingwebcontent.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public Course add(Course course) {
        return repo.save(course);
    }

    public boolean update(String courseID, int newCredits, String newStatus) {
        Optional<Course> opt = repo.findById(courseID);
        if (opt.isPresent()) {
            Course c = opt.get();
            c.setCredits(newCredits);
            c.setStatus(newStatus);
            repo.save(c);
            return true;
        }
        return false;
    }

    public boolean delete(String courseID) {
        if (repo.existsById(courseID)) {
            repo.deleteById(courseID);
            return true;
        }
        return false;
    }

    public List<Course> getAll() {
        return repo.findAll();
    }
}
