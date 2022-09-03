package com.example.youtubemanytomanyjpa.controller;

import com.example.youtubemanytomanyjpa.entity.Course;
import com.example.youtubemanytomanyjpa.entity.Student;
import com.example.youtubemanytomanyjpa.repository.CourseRepository;
import com.example.youtubemanytomanyjpa.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class DemoController {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @PostMapping
    public Student saveStudent(@RequestBody Student studentRequest) {
        return studentRepository.save(studentRequest);
    }

    @GetMapping
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @PostMapping("/{student_id}/course")
    public ResponseEntity<String> createCourse(@PathVariable("student_id") long id, @RequestBody Course courseRequest) {
        studentRepository.findById(id).map(
                student -> {
                    student.addCourse(courseRequest);
                    return courseRepository.save(courseRequest);
                }).orElseThrow(() -> new RuntimeException("Student not found."));
        return ResponseEntity.ok("Create course successfully.");
    }
}
