package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.payload.request.EmployeeRequest;
import com.example.employeemanagementsystem.payload.response.EmployeeResponse;
import com.example.employeemanagementsystem.services.EmployeeServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/ems")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServices employeeServices;

    @PostMapping ("/employees")
    public ResponseEntity<String> addEmployee(@Valid @RequestBody EmployeeRequest  employeeRequest){
        employeeServices.addEmployee(employeeRequest);
        return new ResponseEntity<>("added Successfully", HttpStatus.CREATED);
    }

    @GetMapping ("/employees/{id}")
    public ResponseEntity<EmployeeResponse> searchEmployee(@PathVariable("id") Long id){
        return ResponseEntity.ok(employeeServices.findEmployeeById(id));
    }

    @GetMapping ("/employees")
    public ResponseEntity<List<EmployeeResponse>> displayEmployee(){
        return ResponseEntity.ok(employeeServices.displayAllEmployees());
    }

//    @PostMapping ("/employees")
//    public ResponseEntity<Page<EmployeeResponse>> displayEmployee(@RequestParam(defaultValue = "0" ) int page,@RequestParam(defaultValue = "2") int pageSize,@RequestParam(defaultValue = "id") String sortBy,@RequestParam(defaultValue = "true") boolean ascending){
//        return ResponseEntity.ok(employeeServices.displayAllEmployees(page,pageSize,sortBy,ascending));
//    }

    @PutMapping ("/employees/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable("id") Long id,@Valid @RequestBody EmployeeRequest employeeRequest){
        return ResponseEntity.ok(employeeServices.updateEmployee(id, employeeRequest));
    }

    @DeleteMapping ("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id){
        employeeServices.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
