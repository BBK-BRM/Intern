package org.example.studentmanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table (name = "Addresses")
public class AddressEntity extends BaseEntity{
    private String street;
    private String city;
}
