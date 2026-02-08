package org.example.studentmanagementsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.studentmanagementsystem.entity.AddressEntity;
import org.example.studentmanagementsystem.entity.CourseEntity;
import org.example.studentmanagementsystem.Enum.ChangeStatus;
import org.example.studentmanagementsystem.entity.StudentEntity;
import org.example.studentmanagementsystem.exception.GlobalException;
import org.example.studentmanagementsystem.payload.request.ChangeStatusRequest;
import org.example.studentmanagementsystem.payload.request.StudentDataRequest;
import org.example.studentmanagementsystem.payload.request.StudentRequest;
import org.example.studentmanagementsystem.payload.response.*;
import org.example.studentmanagementsystem.repository.CourseRepository;
import org.example.studentmanagementsystem.repository.StudentRepository;
import org.example.studentmanagementsystem.service.StudentService;
import org.example.studentmanagementsystem.service.specification.StudentSpecification;
import org.example.studentmanagementsystem.util.Helper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public GlobalResponse createStudent(StudentRequest request) {

        if(studentRepository.existsByPhoneNumber(request.getPhoneNumber())){
            throw new GlobalException("Student already exists.");
        }

        CourseEntity course = courseRepository.findByCourseName(request.getCourseName())
                .orElseThrow(()->new GlobalException("Course Not Found."));

        AddressEntity permanentAddress = modelMapper.map(request.getPermanentAddress(),AddressEntity.class);
        AddressEntity temporaryAddress = modelMapper.map(request.getTemporaryAddress(),AddressEntity.class);

        StudentEntity student = StudentEntity.builder()
                .studentName(request.getStudentName())
                .phoneNumber(request.getPhoneNumber())
                .temporaryAddress(temporaryAddress)
                .permanentAddress(permanentAddress)
                .course(course)
//                .deleteFlag(DeleteFlag.FALSE)
                .build();
        studentRepository.save(student);
        return GlobalResponseBuilder.buildSuccessResponse("student created");
    }

    @Override
    public GlobalResponse displayStudents() {
        List<StudentEntity> students = studentRepository.findAllByDeleteFlag(ChangeStatus.ACTIVE);
        List<StudentResponse> response = students.stream()
                .map(student -> StudentResponse.builder()
                        .id(student.getId())
                        .studentName(student.getStudentName())
                        .phoneNumber(student.getPhoneNumber())
                        .courseName(student.getCourse().getCourseName())
                        .permanentAddress(modelMapper.map(student.getPermanentAddress(),AddressResponse.class))
                        .temporaryAddress(modelMapper.map(student.getTemporaryAddress(),AddressResponse.class))
                        .build())
                .toList();
        return GlobalResponseBuilder.buildSuccessResponseWithData("student found",response);
    }

    @Override
    public GlobalResponse displayAllStudents(StudentDataRequest request) {
        Specification<StudentEntity> specification = StudentSpecification.studentFilter(request);
        Page<StudentEntity> page = studentRepository.findAll(specification, Helper.getPage(request));
        List<StudentResponse> studentResponses = page.stream()
                .map(student -> StudentResponse.builder()
                        .id(student.getId())
                        .studentName(student.getStudentName())
                        .phoneNumber(student.getPhoneNumber())
                        .courseName(student.getCourse().getCourseName())
                        .permanentAddress(modelMapper.map(student.getPermanentAddress(),AddressResponse.class))
                        .temporaryAddress(modelMapper.map(student.getTemporaryAddress(),AddressResponse.class))
                        .build())
                .toList();
        PaginatedDataResponse paginatedDataResponse = new PaginatedDataResponse(page.getTotalPages(), studentResponses);
        return GlobalResponseBuilder.buildSuccessResponseWithData("course found",paginatedDataResponse);
    }


    @Override
    public GlobalResponse displayStudentById(Long id) {
        StudentEntity student =studentRepository.findByIdAndDeleteFlag(id, ChangeStatus.ACTIVE)
                .orElseThrow(()->new GlobalException("Student not found"));
        StudentResponse response = StudentResponse.builder()
                .id(student.getId())
                .studentName(student.getStudentName())
                .phoneNumber(student.getPhoneNumber())
                .courseName(student.getCourse().getCourseName())
                .permanentAddress(modelMapper.map(student.getPermanentAddress(),AddressResponse.class))
                .temporaryAddress(modelMapper.map(student.getTemporaryAddress(),AddressResponse.class))
                .build();
        return GlobalResponseBuilder.buildSuccessResponseWithData("student found",response);
    }

    @Override
    public GlobalResponse updateStudent(StudentRequest request, Long id) {
        StudentEntity student = studentRepository.findByIdAndDeleteFlag(id, ChangeStatus.ACTIVE)
                .orElseThrow(()->new GlobalException("Student not found"));

        if(studentRepository.existsByPhoneNumber(request.getPhoneNumber())){
            throw new GlobalException("Student already exists.");
        }

        CourseEntity course = courseRepository.findByCourseName(request.getCourseName())
                .orElseThrow(()->new GlobalException("Course Not Found."));

        AddressEntity permanentAddress = modelMapper.map(request.getPermanentAddress(),AddressEntity.class);
        AddressEntity temporaryAddress = modelMapper.map(request.getTemporaryAddress(),AddressEntity.class);

        student.setStudentName(request.getStudentName());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setTemporaryAddress(temporaryAddress);
        student.setPermanentAddress(permanentAddress);
        student.setCourse(course);
        // student.setDeleteFlag(DeleteFlag.FALSE);

        studentRepository.save(student);
        return GlobalResponseBuilder.buildSuccessResponse("student updated");
    }

    @Override
    public GlobalResponse changeStatusStudent(Long id, ChangeStatusRequest status) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(()->new GlobalException("Student not found."));
        student.setStatus(status.getStatus());
        student.getPermanentAddress().setStatus(status.getStatus());
        student.getTemporaryAddress().setStatus(status.getStatus());
        studentRepository.save(student);
        return GlobalResponseBuilder.buildSuccessResponse("student status changed");
    }
}