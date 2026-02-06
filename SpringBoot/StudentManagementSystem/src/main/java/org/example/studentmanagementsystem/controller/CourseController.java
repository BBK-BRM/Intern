package org.example.studentmanagementsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.studentmanagementsystem.payload.request.CourseDataRequest;
import org.example.studentmanagementsystem.payload.request.CourseRequest;
import org.example.studentmanagementsystem.payload.request.PageDataRequest;
import org.example.studentmanagementsystem.payload.response.CourseResponse;
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
    public ResponseEntity<Void> createCourse(@Valid @RequestBody CourseRequest request) {
        courseService.createCourse(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponse>> displayAllActiveCourses() {
        List<CourseResponse> responses = courseService.displayAllActiveCourses();
        return ResponseEntity.ok(responses);
    }

    @PostMapping("all-list")
    public ResponseEntity<PaginatedDataResponse> displayAllCourses(@RequestBody CourseDataRequest request){
       PaginatedDataResponse responses = courseService.displayAllCourses(request);
       return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> displayCourseById(@PathVariable Long id) {
        CourseResponse response = courseService.displayById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable Long id, @Valid @RequestBody CourseRequest request) {
        courseService.updateCourse(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourses(id);
        return ResponseEntity.noContent().build();
    }
}
