package org.example.studentmanagementsystem.payload.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Long id;
    private String  studentName;
    private String phoneNumber;
    private String courseName;

    private AddressResponse permanentAddress;
    private AddressResponse temporaryAddress;
}
