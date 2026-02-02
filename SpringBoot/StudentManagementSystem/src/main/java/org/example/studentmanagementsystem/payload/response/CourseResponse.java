package org.example.studentmanagementsystem.payload.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponse {
    private Long courseId;
    private String courseName;
    private String professorName;
}
