package org.example.studentmanagementsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.studentmanagementsystem.payload.request.ChangeStatusRequest;
import org.example.studentmanagementsystem.payload.request.CourseDataRequest;
import org.example.studentmanagementsystem.payload.request.CourseRequest;
import org.example.studentmanagementsystem.payload.request.PageDataRequest;
import org.example.studentmanagementsystem.payload.response.CourseResponse;
import org.example.studentmanagementsystem.payload.response.GlobalResponse;
import org.example.studentmanagementsystem.payload.response.PaginatedDataResponse;
import org.example.studentmanagementsystem.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sms/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<GlobalResponse> createCourse(@Valid @RequestBody CourseRequest request) {
        return new ResponseEntity<>(courseService.createCourse(request),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<GlobalResponse> displayAllActiveCourses() {
        return ResponseEntity.ok(courseService.displayAllActiveCourses());
    }

    @PostMapping("all-list")
    public ResponseEntity<GlobalResponse> displayAllCourses(@RequestBody CourseDataRequest request){
       return ResponseEntity.ok(courseService.displayAllCourses(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponse> displayCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.displayById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalResponse> updateCourse(@PathVariable Long id, @Valid @RequestBody CourseRequest request) {
        return ResponseEntity.ok(courseService.updateCourse(id, request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GlobalResponse> changeStatusCourse(@PathVariable Long id, @Valid @RequestBody ChangeStatusRequest request) {
        return ResponseEntity.ok(courseService.changeStatusCourses(id,request));
    }
}
