package org.example.databasetablerelations.payload.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponse {
    private Long id;
    private String courseName;
}
