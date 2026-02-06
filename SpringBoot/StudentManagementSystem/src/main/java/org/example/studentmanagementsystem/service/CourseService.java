package org.example.studentmanagementsystem.service;

import org.example.studentmanagementsystem.payload.request.CourseDataRequest;
import org.example.studentmanagementsystem.payload.request.CourseRequest;
import org.example.studentmanagementsystem.payload.request.PageDataRequest;
import org.example.studentmanagementsystem.payload.response.CourseResponse;
import org.example.studentmanagementsystem.payload.response.PaginatedDataResponse;

import java.util.List;

public interface CourseService {
    void createCourse(CourseRequest request);
    List<CourseResponse> displayAllActiveCourses();
    PaginatedDataResponse displayAllCourses(CourseDataRequest request);
    CourseResponse displayById(Long id);
    void updateCourse(Long id, CourseRequest request);
    void deleteCourses(Long id);
}
