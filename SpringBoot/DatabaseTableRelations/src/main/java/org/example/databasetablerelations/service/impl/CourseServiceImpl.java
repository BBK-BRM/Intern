package org.example.databasetablerelations.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.databasetablerelations.entity.CoursesEntity;
import org.example.databasetablerelations.exception.GlobalException;
import org.example.databasetablerelations.payload.request.CourseRequest;
import org.example.databasetablerelations.payload.request.PaginatedDataRequest;
import org.example.databasetablerelations.payload.response.CourseResponse;
import org.example.databasetablerelations.payload.response.GlobalResponse;
import org.example.databasetablerelations.payload.response.GlobalResponseBuilder;
import org.example.databasetablerelations.payload.response.PaginatedDataResponse;
import org.example.databasetablerelations.repository.CourseRepository;
import org.example.databasetablerelations.service.CourseService;
import org.example.databasetablerelations.util.Helper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public GlobalResponse createCourse(CourseRequest request) {
        if(courseRepository.existsByCourseName(request.getCourseName())){
            throw new GlobalException("course already exists");
        }
        CoursesEntity course =  CoursesEntity.builder()
                .courseName(request.getCourseName())
                .build();
        courseRepository.save(course);
        return GlobalResponseBuilder.buildSuccessResponse("course created");
    }

    @Override
    public GlobalResponse displayAllCourses() {
        List<CoursesEntity> courses = courseRepository.findAll();
        List<CourseResponse> responses = courses.stream()
                .map(course -> CourseResponse.builder()
                            .id(course.getId())
                            .courseName(course.getCourseName())
                            .build()
                ).toList();
        return GlobalResponseBuilder.buildSuccessResponseWithData("course found",responses);
    }

    @Override
    public GlobalResponse displayPaginatedCourses(PaginatedDataRequest request) {
        Page<CoursesEntity> courses = courseRepository.findAll(Helper.getPageable(request));
        List<CourseResponse> courseResponses = courses.getContent().stream()
                .map(courseResponse -> modelMapper.map(courseResponse,CourseResponse.class))
                .toList();
        PaginatedDataResponse response = PaginatedDataResponse.builder()
                .totalPageNo(courses.getTotalPages())
                .data(courseResponses)
                .build();
        return GlobalResponseBuilder.buildSuccessResponseWithData("course found",response);
    }


    @Override
    public GlobalResponse updateCourse(Long id,CourseRequest request) {
        CoursesEntity course = courseRepository.findById(id)
                .orElseThrow(()->new GlobalException("course not found"));
        course.setCourseName(request.getCourseName());
        courseRepository.save(course);
        return GlobalResponseBuilder.buildSuccessResponse("course updated");
    }

    @Override
    public GlobalResponse deleteCourse(Long id) {
        if(!courseRepository.existsById(id)) {
            throw new GlobalException("course not found");
        }
        courseRepository.deleteById(id);
        return GlobalResponseBuilder.buildSuccessResponse("couese deleted");
    }
}
