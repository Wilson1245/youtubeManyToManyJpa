package com.example.youtubemanytomanyjpa.repository;

import com.example.youtubemanytomanyjpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
