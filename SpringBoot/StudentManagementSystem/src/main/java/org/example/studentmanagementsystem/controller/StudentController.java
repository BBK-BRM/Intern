package org.example.studentmanagementsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.studentmanagementsystem.payload.request.StudentRequest;
import org.example.studentmanagementsystem.payload.response.StudentResponse;
import org.example.studentmanagementsystem.service.impl.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sms/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServiceImpl studentService;

    @PostMapping
    public ResponseEntity<String> createStudent(@Valid @RequestBody StudentRequest request){
        studentService.createStudent(request);
        return new ResponseEntity<>("Student Added Successfully",HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> displayAllStudents(){
        List<StudentResponse> response = studentService.displayStudents();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> displayStudentById(@PathVariable Long id){
        StudentResponse response = studentService.displayStudentById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudentById(@PathVariable Long id,@RequestBody StudentRequest request){
        studentService.updateStudent(request,id);
        return ResponseEntity.ok("Student updated sucessfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student Deleted Successfully");
    }
}
