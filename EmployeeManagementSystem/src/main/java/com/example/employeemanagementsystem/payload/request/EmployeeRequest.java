package com.example.employeemanagementsystem.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    @NotBlank (message = "Required name")
    private String name;

    @NotNull(message = "Required age")
    private int age;

    @NotBlank (message = "Required post")
    private String post;
}
