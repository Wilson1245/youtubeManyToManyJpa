package com.example.youtubemanytomanyjpa.repository;

import com.example.youtubemanytomanyjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
