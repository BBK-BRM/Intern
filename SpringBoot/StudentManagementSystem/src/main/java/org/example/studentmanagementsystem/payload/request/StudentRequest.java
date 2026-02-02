package org.example.studentmanagementsystem.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    @NotBlank  (message = "Student name is required")
    private String studentName;

    @NotBlank (message = "Phone number is required")
    private String phoneNumber;

    @NotBlank (message = "Course name is required")
    private String courseName;

    private AddressRequest permanentAddress;
    private AddressRequest temporaryAddress;

}
