package org.example.databasetablerelations.service;

import org.example.databasetablerelations.payload.request.CourseRequest;
import org.example.databasetablerelations.payload.request.PaginatedDataRequest;
import org.example.databasetablerelations.payload.response.CourseResponse;
import org.example.databasetablerelations.payload.response.GlobalResponse;
import org.example.databasetablerelations.payload.response.PaginatedDataResponse;

import java.util.List;

public interface CourseService {
    GlobalResponse createCourse(CourseRequest request);
    GlobalResponse displayAllCourses();
    GlobalResponse displayPaginatedCourses(PaginatedDataRequest request);
    GlobalResponse updateCourse(Long id,CourseRequest request);
    GlobalResponse deleteCourse(Long id);
}
