package org.example.studentmanagementsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.studentmanagementsystem.payload.request.ChangeStatusRequest;
import org.example.studentmanagementsystem.payload.request.StudentRequest;
import org.example.studentmanagementsystem.payload.response.GlobalResponse;
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
    public ResponseEntity<GlobalResponse> createStudent(@Valid @RequestBody StudentRequest request){
        return new ResponseEntity<>(studentService.createStudent(request),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<GlobalResponse> displayAllStudents(){
        return ResponseEntity.ok(studentService.displayStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponse> displayStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.displayStudentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalResponse> updateStudentById(@PathVariable Long id,@RequestBody StudentRequest request){
        return ResponseEntity.ok(studentService.updateStudent(request,id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GlobalResponse> deleteStudent(@PathVariable Long id, @Valid @RequestBody ChangeStatusRequest status){
        return ResponseEntity.ok(studentService.changeStatusStudent(id,status));
    }
}
