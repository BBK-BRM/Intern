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
@Table (name = "courses")
public class CoursesEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    @ManyToMany (mappedBy = "enrolledCourses")
    private List<StudentsEntity> students = new ArrayList<>();
}
