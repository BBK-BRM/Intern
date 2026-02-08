package org.example.studentmanagementsystem.service;

import org.example.studentmanagementsystem.payload.request.ChangeStatusRequest;
import org.example.studentmanagementsystem.payload.request.StudentDataRequest;
import org.example.studentmanagementsystem.payload.request.StudentRequest;
import org.example.studentmanagementsystem.payload.response.GlobalResponse;

import org.example.studentmanagementsystem.payload.response.StudentResponse;

import java.util.List;

public interface StudentService {
    GlobalResponse createStudent(StudentRequest request);
    GlobalResponse displayStudents();
    GlobalResponse displayAllStudents(StudentDataRequest request);
    GlobalResponse displayStudentById(Long id);
    GlobalResponse updateStudent(StudentRequest request,Long id);
    GlobalResponse changeStatusStudent(Long id, ChangeStatusRequest status);
}
