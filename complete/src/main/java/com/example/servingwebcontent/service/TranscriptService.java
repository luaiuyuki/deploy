package com.example.servingwebcontent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.servingwebcontent.model.Transcript;
import com.example.servingwebcontent.repository.TranscriptRepository;

@Service
public class TranscriptService {
    private final TranscriptRepository repo;

    public TranscriptService(TranscriptRepository repo) {
        this.repo = repo;
    }


    public Transcript add(Transcript t) {
        return repo.save(t);
    }

    public Optional<Transcript> findByStudentAndCourse(String studentId, String courseId) {
        return repo.findByStudent_StudentIdAndCourse_CourseID(studentId, courseId);
    
    }

  
    public boolean updateGrade(String studentId, String courseId, float newGrade) {
        Optional<Transcript> opt = findByStudentAndCourse(studentId, courseId);
        if (opt.isPresent()) {
            Transcript t = opt.get();
            t.setGrade10(newGrade);
            repo.save(t);
            return true;
        }
        return false;
    }

    public boolean delete(String studentId, String courseId) {
        Optional<Transcript> opt = findByStudentAndCourse(studentId, courseId);
        if (opt.isPresent()) {
            repo.delete(opt.get());
            return true;
        }
        return false;
    }


    public List<Transcript> getAll() {
        return repo.findAll();
    }
}
