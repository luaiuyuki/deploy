package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.Student;
import com.example.servingwebcontent.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student add(Student s) {
        return repo.save(s);
    }

    public boolean update(String id, String newName, String newMajor) {
        Optional<Student> opt = repo.findById(id);
        if (opt.isPresent()) {
            Student s = opt.get();
            s.setFullname(newName);
            s.setMajor(newMajor);
            repo.save(s);
            return true;
        }
        return false;
    }

    public boolean delete(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Student> getAll() {
        return repo.findAll();
    }
}
