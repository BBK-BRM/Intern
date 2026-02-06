package org.example.studentmanagementsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.studentmanagementsystem.entity.AddressEntity;
import org.example.studentmanagementsystem.entity.CourseEntity;
import org.example.studentmanagementsystem.Enum.DeleteFlag;
import org.example.studentmanagementsystem.entity.StudentEntity;
import org.example.studentmanagementsystem.exception.ResourceAlreadyExistsException;
import org.example.studentmanagementsystem.exception.ResourseNotFoundException;
import org.example.studentmanagementsystem.payload.request.StudentRequest;
import org.example.studentmanagementsystem.payload.response.AddressResponse;
import org.example.studentmanagementsystem.payload.response.StudentResponse;
import org.example.studentmanagementsystem.repository.CourseRepository;
import org.example.studentmanagementsystem.repository.StudentRepository;
import org.example.studentmanagementsystem.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createStudent(StudentRequest request) {

        if(studentRepository.existsByPhoneNumber(request.getPhoneNumber())){
            throw new ResourceAlreadyExistsException("Student already exists.");
        }

        CourseEntity course = courseRepository.findByCourseName(request.getCourseName())
                .orElseThrow(()->new ResourseNotFoundException("Course Not Found."));

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
    }

    @Override
    public List<StudentResponse> displayStudents() {
        List<StudentEntity> students = studentRepository.findAllByDeleteFlag(DeleteFlag.FALSE);
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
        return response;
    }

    @Override
    public StudentResponse displayStudentById(Long id) {
        StudentEntity student =studentRepository.findByIdAndDeleteFlag(id,DeleteFlag.FALSE)
                .orElseThrow(()->new ResourseNotFoundException("Student not found"));
        StudentResponse response = StudentResponse.builder()
                .id(student.getId())
                .studentName(student.getStudentName())
                .phoneNumber(student.getPhoneNumber())
                .courseName(student.getCourse().getCourseName())
                .permanentAddress(modelMapper.map(student.getPermanentAddress(),AddressResponse.class))
                .temporaryAddress(modelMapper.map(student.getTemporaryAddress(),AddressResponse.class))
                .build();
        return response;
    }

    @Override
    public void updateStudent(StudentRequest request, Long id) {
        StudentEntity student = studentRepository.findByIdAndDeleteFlag(id,DeleteFlag.FALSE)
                .orElseThrow(()->new ResourseNotFoundException("Student not found"));

        if(studentRepository.existsByPhoneNumber(request.getPhoneNumber())){
            throw new ResourceAlreadyExistsException("Student already exists.");
        }

        CourseEntity course = courseRepository.findByCourseName(request.getCourseName())
                .orElseThrow(()->new ResourseNotFoundException("Course Not Found."));

        AddressEntity permanentAddress = modelMapper.map(request.getPermanentAddress(),AddressEntity.class);
        AddressEntity temporaryAddress = modelMapper.map(request.getTemporaryAddress(),AddressEntity.class);

        student.setStudentName(request.getStudentName());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setTemporaryAddress(temporaryAddress);
        student.setPermanentAddress(permanentAddress);
        student.setCourse(course);
        // student.setDeleteFlag(DeleteFlag.FALSE);

        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        StudentEntity student = studentRepository.findByIdAndDeleteFlag(id,DeleteFlag.FALSE)
                .orElseThrow(()->new ResourseNotFoundException("Student not found."));
        student.setDeleteFlag(DeleteFlag.TRUE);
        student.getPermanentAddress().setDeleteFlag(DeleteFlag.TRUE);
        student.getTemporaryAddress().setDeleteFlag(DeleteFlag.TRUE);
        studentRepository.save(student);
    }
}