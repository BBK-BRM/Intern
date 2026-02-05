package org.example.databasetablerelations.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.databasetablerelations.payload.request.StudentRequest;
import org.example.databasetablerelations.payload.response.StudentResponse;
import org.example.databasetablerelations.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentController {
    public final StudentService studentService;

    @PostMapping
    public ResponseEntity<Void> createStudent(@Valid @RequestBody StudentRequest request){
        studentService.createStudent(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudent(){
        return ResponseEntity.ok(studentService.displayAllStudent());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id,@Valid @RequestBody StudentRequest request){
        studentService.updateStudent(id,request);
        return ResponseEntity.ok("student updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("student deleted.");
    }

}
