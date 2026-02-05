package org.example.databasetablerelations.service;

import org.example.databasetablerelations.payload.request.StudentRequest;
import org.example.databasetablerelations.payload.response.StudentResponse;

import java.util.List;

public interface StudentService {
    void createStudent(StudentRequest request);
    List<StudentResponse> displayAllStudent();
    void deleteStudent(Long id);
    void updateStudent(Long id,StudentRequest request);
}
