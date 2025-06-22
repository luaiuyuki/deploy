package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Transcript;
import com.example.servingwebcontent.service.TranscriptService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transcripts")
public class TranscriptController {

    private final TranscriptService service;

    public TranscriptController(TranscriptService service) {
        this.service = service;
    }

   
    @GetMapping
    public List<Transcript> getAllTranscripts() {
        return service.getAll();
    }


    @PostMapping
    public Transcript addTranscript(@RequestBody Transcript t) {
        return service.add(t);
    }

    @PutMapping("/update-grade")
    public boolean updateGrade(@RequestParam String studentId,
                               @RequestParam String courseId,
                               @RequestParam float newGrade) {
        return service.updateGrade(studentId, courseId, newGrade);
    }


    @PutMapping("/update")
    public boolean updateTranscript(@RequestBody Transcript t) {
        String studentId = t.getStudent().getStudentId();
        String courseId = t.getCourse().getCourseID();

        Optional<Transcript> opt = service.findByStudentAndCourse(studentId, courseId);
        if (opt.isPresent()) {
            Transcript existing = opt.get();
            existing.setGrade10(t.getGrade10());
            existing.setSemester(t.getSemester());
            service.add(existing); // save
            return true;
        }
        return false;
    }

    @DeleteMapping("/delete")
    public boolean deleteTranscript(@RequestParam String studentId,
                                    @RequestParam String courseId) {
        return service.delete(studentId, courseId);
    }
}
