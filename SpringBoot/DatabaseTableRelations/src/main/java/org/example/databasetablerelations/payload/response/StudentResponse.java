package org.example.databasetablerelations.payload.response;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private String studentName;
    private int studentRollNo;
    private List<CourseResponse> enrolledCourses;
}
