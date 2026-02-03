package com.example.employeemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "employees")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String name;

    private int age;
    private String post;
}
