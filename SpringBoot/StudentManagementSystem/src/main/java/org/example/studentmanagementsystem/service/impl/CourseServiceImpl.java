package org.example.studentmanagementsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.studentmanagementsystem.entity.CourseEntity;
import org.example.studentmanagementsystem.Enum.DeleteFlag;
import org.example.studentmanagementsystem.entity.ProfessorEntity;
import org.example.studentmanagementsystem.exception.ResourseNotFoundException;
import org.example.studentmanagementsystem.payload.request.CourseDataRequest;
import org.example.studentmanagementsystem.payload.request.CourseRequest;
import org.example.studentmanagementsystem.payload.request.PageDataRequest;
import org.example.studentmanagementsystem.payload.response.CourseResponse;
import org.example.studentmanagementsystem.payload.response.PaginatedDataResponse;
import org.example.studentmanagementsystem.repository.CourseRepository;
import org.example.studentmanagementsystem.service.CourseService;
import org.example.studentmanagementsystem.service.specification.CourseSpecification;
import org.example.studentmanagementsystem.util.Helper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createCourse(CourseRequest request) {
        ProfessorEntity professor = ProfessorEntity.builder()
                .professorName(request.getProfessorName())
//                .deleteFlag(DeleteFlag.FALSE)
                .build();
        CourseEntity course = CourseEntity.builder()
                .courseName(request.getCourseName())
                .professor(professor)
//                .deleteFlag(DeleteFlag.FALSE)
                .build();
        courseRepository.save(course);
    }

    @Override
    public List<CourseResponse> displayAllActiveCourses(){
        List<CourseEntity> courses = courseRepository.findAllByDeleteFlag(DeleteFlag.FALSE);

//        List<CourseResponse> responses = courses.stream()
//                .map(course -> CourseResponse.builder()
//                        .courseId(course.getId())
//                        .courseName(course.getCourseName())
//                        .professorName(course.getProfessor().getProfessorName())
//                        .build()
//                ).toList();

        List<CourseResponse> responses = courses.stream()
                .map(course->modelMapper.map(course,CourseResponse.class))
                .toList();
        return responses;
    }

    public PaginatedDataResponse displayAllCourses(CourseDataRequest request){
        Specification<CourseEntity> specification = CourseSpecification.courseFilter(request);
        Page<CourseEntity> page =  courseRepository.findAll(specification,Helper.getPage(request));
        List<CourseResponse> courseResponses = page.stream()
                .map(courseEntity -> modelMapper.map(courseEntity,CourseResponse.class))
                .toList();
        PaginatedDataResponse response = new PaginatedDataResponse(page.getTotalPages(), courseResponses);
        return response;
    }

    @Override
    public void updateCourse(Long id, CourseRequest request) {
        CourseEntity course  = courseRepository.findByIdAndDeleteFlag(id,DeleteFlag.FALSE)
                .orElseThrow(()->new ResourseNotFoundException("Course not found."));
        course.setCourseName(request.getCourseName());
        course.getProfessor().setProfessorName(request.getProfessorName());

        courseRepository.save(course);
    }

    @Override
    public CourseResponse displayById(Long id){
        CourseEntity course = courseRepository.findByIdAndDeleteFlag(id,DeleteFlag.FALSE)
                .orElseThrow(()->new ResourseNotFoundException("Course not found"));

//        CourseResponse response = CourseResponse.builder()
//                .courseId(course.getId())
//                .courseName(course.getCourseName())
//                .professorName(course.getProfessor().getProfessorName())
//                .build();

        CourseResponse response = modelMapper.map(course,CourseResponse.class);
        return response;
    }

    @Override
    public void deleteCourses(Long id) {
        CourseEntity course  = courseRepository.findByIdAndDeleteFlag(id,DeleteFlag.FALSE)
                .orElseThrow(()->new ResourseNotFoundException("Course not found."));
        course.setDeleteFlag(DeleteFlag.TRUE);
        course.getProfessor().setDeleteFlag(DeleteFlag.TRUE);
        courseRepository.save(course);
    }
}
