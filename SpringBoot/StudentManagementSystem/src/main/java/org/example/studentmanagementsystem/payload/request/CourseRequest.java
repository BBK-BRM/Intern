package org.example.studentmanagementsystem.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {
    @NotBlank (message = "Course name is required")
    private String courseName;

    @NotBlank (message = "Professor name is required")
    private String professorName;

}
