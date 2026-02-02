package org.example.studentmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class CourseEntity extends BaseEntity{

    @Column (nullable = false, unique = true)
    private String courseName;

    @OneToMany (mappedBy = "course")
    private List<StudentEntity> student = new ArrayList<>();

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private ProfessorEntity professor;

}
