package org.example.studentmanagementsystem.service;

import org.example.studentmanagementsystem.payload.request.StudentRequest;
import org.example.studentmanagementsystem.payload.response.StudentResponse;

import java.util.List;

public interface StudentService {
    void createStudent(StudentRequest request);
    List<StudentResponse> displayStudents();
    StudentResponse displayStudentById(Long id);
    void updateStudent(StudentRequest request,Long id);
    void deleteStudent(Long id);
}
