package org.example.databasetablerelations.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest {
    @NotBlank (message = "Student name is required")
    private String studentName;

    @NotNull(message = "Roll no is required")
    private Integer studentRollNo;

    @NotEmpty(message = "At least one course ID is required")
    private List<Long> courseId;
}
