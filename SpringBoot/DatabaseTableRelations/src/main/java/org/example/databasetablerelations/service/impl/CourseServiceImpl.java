package org.example.databasetablerelations.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.databasetablerelations.entity.CoursesEntity;
import org.example.databasetablerelations.exception.GlobalException;
import org.example.databasetablerelations.payload.request.CourseRequest;
import org.example.databasetablerelations.payload.response.CourseResponse;
import org.example.databasetablerelations.repository.CourseRepository;
import org.example.databasetablerelations.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public void createCourse(CourseRequest request) {
        if(courseRepository.existsByCourseName(request.getCourseName())){
            throw new GlobalException("course already exists");
        }
        CoursesEntity course =  CoursesEntity.builder()
                .courseName(request.getCourseName())
                .build();
        courseRepository.save(course);
    }

    @Override
    public List<CourseResponse> displayAllCourses() {
        List<CoursesEntity> courses = courseRepository.findAll();
        List<CourseResponse> responses = courses.stream()
                .map(course -> CourseResponse.builder()
                            .id(course.getId())
                            .courseName(course.getCourseName())
                            .build()
                ).toList();
        return responses;
    }

    @Override
    public void updateCourse(Long id,CourseRequest request) {
        CoursesEntity course = courseRepository.findById(id)
                .orElseThrow(()->new GlobalException("course not found"));
        course.setCourseName(request.getCourseName());
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        if(!courseRepository.existsById(id)) {
            throw new GlobalException("course not found");
        }
        courseRepository.deleteById(id);
    }
}
