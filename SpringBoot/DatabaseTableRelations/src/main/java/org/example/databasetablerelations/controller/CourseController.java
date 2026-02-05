package org.example.databasetablerelations.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.databasetablerelations.payload.request.CourseRequest;
import org.example.databasetablerelations.payload.response.CourseResponse;
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
    public ResponseEntity<String> createCourse(@Valid @RequestBody CourseRequest request){
        courseService.createCourse(request);
        return new ResponseEntity<>("course created",HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponse>> displayAllCourses(){
        return ResponseEntity.ok(courseService.displayAllCourses());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable Long id,@Valid @RequestBody CourseRequest request){
        courseService.updateCourse(id,request);
        return ResponseEntity.ok("course updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return new ResponseEntity<>("course deleted",HttpStatus.NO_CONTENT);
    }
}
