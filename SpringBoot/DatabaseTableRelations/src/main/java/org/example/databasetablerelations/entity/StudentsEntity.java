package org.example.databasetablerelations.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "students")
public class StudentsEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String studentName;

    private Integer studentRollNo;

    @ManyToMany (cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "student_course",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<CoursesEntity> enrolledCourses = new ArrayList<>();

}
