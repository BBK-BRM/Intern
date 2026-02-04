package org.example.authenticationsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column (unique = true)
    private String username;

    private String email;
    private String password;
    private String role;
}
