package org.example.databasetablerelations.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.databasetablerelations.entity.CoursesEntity;
import org.example.databasetablerelations.entity.StudentsEntity;
import org.example.databasetablerelations.exception.GlobalException;
import org.example.databasetablerelations.payload.request.StudentRequest;
import org.example.databasetablerelations.payload.response.CourseResponse;
import org.example.databasetablerelations.payload.response.StudentResponse;
import org.example.databasetablerelations.repository.CourseRepository;
import org.example.databasetablerelations.repository.StudentRepository;
import org.example.databasetablerelations.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createStudent(StudentRequest request) {
        List<CoursesEntity> courses = courseRepository.findAllById(request.getCourseId());
        if(courses.size() != request.getCourseId().size()){
            throw new GlobalException("course not found");
        }
        StudentsEntity student = StudentsEntity.builder()
                .studentName(request.getStudentName())
                .studentRollNo(request.getStudentRollNo())
                .enrolledCourses(courses)
                .build();
        studentRepository.save(student);
    }

    @Override
    public List<StudentResponse> displayAllStudent() {
        List<StudentsEntity> students = studentRepository.findAll();

//        List<StudentResponse> response = students.stream()
//                .map(student -> StudentResponse.builder()
//                        .studentName(student.getStudentName())
//                        .studentRollNo(student.getStudentRollNo())
//                        .courses(student.getEnrolledCourses().stream()
//                                .map(course -> modelMapper.map(course,CourseResponse.class)
//                                ).toList())
//                        .build()
//                ).toList();

        List<StudentResponse> response = students.stream()
                .map(student -> modelMapper.map(student,StudentResponse.class)
                ).toList();
        return response;
    }

    @Override
    public void updateStudent(Long id, StudentRequest request) {
        StudentsEntity student = studentRepository.findById(id)
                .orElseThrow(()-> new GlobalException("student not found."));

        List<CoursesEntity> courses = courseRepository.findAllById(request.getCourseId());
        if(courses.size() != request.getCourseId().size()){
            throw new GlobalException("course not found");
        }

        student.setStudentName(request.getStudentName());
        student.setStudentRollNo(request.getStudentRollNo());
        student.setEnrolledCourses(courses);

        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id)){
            throw new GlobalException("student not found");
        }
        studentRepository.deleteById(id);
    }

}
