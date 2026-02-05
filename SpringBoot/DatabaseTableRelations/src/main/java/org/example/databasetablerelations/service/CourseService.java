package org.example.databasetablerelations.service;

import org.example.databasetablerelations.payload.request.CourseRequest;
import org.example.databasetablerelations.payload.response.CourseResponse;

import java.util.List;

public interface CourseService {
    void createCourse(CourseRequest request);
    List<CourseResponse> displayAllCourses();
    void updateCourse(Long id,CourseRequest request);
    void deleteCourse(Long id);
}
