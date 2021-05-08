package com.biblio.bibliotheque.controller;

import java.util.List;

import com.biblio.bibliotheque.Exceptions.StudentNotFoundException;
import com.biblio.bibliotheque.entity.Student;
import com.biblio.bibliotheque.repository.StudentRepo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private StudentRepo repository;

    StudentController(StudentRepo repo) {
        this.repository = repo;
    }

    // Aggregare root
    @GetMapping("/students")
    List<Student> all() {
        return repository.findAll();
    }

    @PostMapping("/students")
    Student newStudent(@RequestBody Student newStudent) {
        return repository.save(newStudent);
    }

    // Single item
    @GetMapping("/students/{id}")
    Student one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @PostMapping("students/{id}")
    Student replaceStudent(@RequestBody Student newStudent, @PathVariable long id) {
        return repository.findById(id).map(student -> {
            student.setFirstName(newStudent.getFirstName());
            student.setLastName(newStudent.getLastName());
            student.setEmail(newStudent.getEmail());
            return repository.save(student);
        }).orElseGet(() -> {
            newStudent.setId(id);
            return repository.save(newStudent);
        });
    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable long id) {
        repository.deleteById(id);
    }
}
