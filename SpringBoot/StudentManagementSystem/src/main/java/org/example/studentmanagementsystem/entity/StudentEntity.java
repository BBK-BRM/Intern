package org.example.studentmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "students")
public class StudentEntity extends BaseEntity {

    @Column (nullable = false)
    private String studentName;

    @ManyToOne()
    @JoinColumn (name = "course_id")
    private CourseEntity course;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @OneToOne (cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private AddressEntity permanentAddress;

    @OneToOne (cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private AddressEntity temporaryAddress;

}
