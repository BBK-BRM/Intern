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
@Table (name = "professors")
public class ProfessorEntity extends BaseEntity{

    @Column(nullable = false)
    private String professorName;
}
