package com.example.servingwebcontent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.servingwebcontent.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
}
