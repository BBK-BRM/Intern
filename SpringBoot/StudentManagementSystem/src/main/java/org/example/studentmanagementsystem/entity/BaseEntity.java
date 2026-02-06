package org.example.studentmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.studentmanagementsystem.Enum.DeleteFlag;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    @Builder.Default
//    private DeleteFlag deleteFlag;
    private DeleteFlag deleteFlag = DeleteFlag.FALSE;
}
