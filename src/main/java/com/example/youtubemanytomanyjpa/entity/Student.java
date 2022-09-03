package com.example.youtubemanytomanyjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int age;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE",
    joinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "id")
    })
    private Set<Course> courses = new HashSet<>();

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.getStudents().add(this);
    }
}
