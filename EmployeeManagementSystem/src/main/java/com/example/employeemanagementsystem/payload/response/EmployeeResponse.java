package com.example.employeemanagementsystem.payload.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private  Long id;
    private String name;
    private int age;
    private String post;
}
