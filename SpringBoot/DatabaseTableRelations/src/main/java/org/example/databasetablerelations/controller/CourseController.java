package org.example.databasetablerelations.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.databasetablerelations.payload.request.CourseRequest;
import org.example.databasetablerelations.payload.request.PaginatedDataRequest;
import org.example.databasetablerelations.payload.response.CourseResponse;
import org.example.databasetablerelations.payload.response.GlobalResponse;
import org.example.databasetablerelations.payload.response.PaginatedDataResponse;
import org.example.databasetablerelations.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<GlobalResponse> createCourse(@Valid @RequestBody CourseRequest request){
        return new ResponseEntity<>(courseService.createCourse(request),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<GlobalResponse> displayAllCourses(){
        return ResponseEntity.ok(courseService.displayAllCourses());
    }

    @PostMapping("/paginatedCourses")
    public ResponseEntity<GlobalResponse> displayPaginatedCourses(@RequestBody PaginatedDataRequest request){
        return ResponseEntity.ok(courseService.displayPaginatedCourses(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalResponse> updateCourse(@PathVariable Long id,@Valid @RequestBody CourseRequest request){

        return ResponseEntity.ok(courseService.updateCourse(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return new ResponseEntity<>("course deleted",HttpStatus.NO_CONTENT);
    }
}
