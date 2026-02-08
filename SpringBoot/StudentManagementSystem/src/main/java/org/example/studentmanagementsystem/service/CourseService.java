package org.example.studentmanagementsystem.service;

import org.example.studentmanagementsystem.payload.request.ChangeStatusRequest;
import org.example.studentmanagementsystem.payload.request.CourseDataRequest;
import org.example.studentmanagementsystem.payload.request.CourseRequest;
import org.example.studentmanagementsystem.payload.request.PageDataRequest;
import org.example.studentmanagementsystem.payload.response.CourseResponse;
import org.example.studentmanagementsystem.payload.response.GlobalResponse;
import org.example.studentmanagementsystem.payload.response.PaginatedDataResponse;

import java.util.List;

public interface CourseService {
    GlobalResponse createCourse(CourseRequest request);
    GlobalResponse displayAllActiveCourses();
    GlobalResponse displayAllCourses(CourseDataRequest request);
    GlobalResponse displayById(Long id);
    GlobalResponse updateCourse(Long id, CourseRequest request);
    GlobalResponse changeStatusCourses(Long id, ChangeStatusRequest request);
}
