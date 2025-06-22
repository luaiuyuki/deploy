package com.example.servingwebcontent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.servingwebcontent.model.Transcript;

public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
    Optional<Transcript> findByStudent_StudentIdAndCourse_CourseID(String studentId, String courseId);
}
