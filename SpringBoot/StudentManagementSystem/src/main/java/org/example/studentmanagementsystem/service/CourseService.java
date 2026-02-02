package org.example.studentmanagementsystem.service;

import org.example.studentmanagementsystem.payload.request.CourseRequest;
import org.example.studentmanagementsystem.payload.response.CourseResponse;

import java.util.List;

public interface CourseService {
    void createCourse(CourseRequest request);
    List<CourseResponse> displayAllCourses();
    CourseResponse displayById(Long id);
    void updateCourse(Long id, CourseRequest request);
    void deleteCourses(Long id);
}
