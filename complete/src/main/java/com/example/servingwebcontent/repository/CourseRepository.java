package com.example.servingwebcontent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.servingwebcontent.model.Course;

public interface CourseRepository extends JpaRepository<Course, String> {

}
