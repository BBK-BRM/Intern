package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.payload.request.EmployeeRequest;
import com.example.employeemanagementsystem.payload.response.EmployeeResponse;
import com.example.employeemanagementsystem.services.EmployeeServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/ems")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServices employeeServices;

    @PostMapping ("/employee")
    public ResponseEntity<EmployeeResponse> addEmployee(@Valid @RequestBody EmployeeRequest  employeeRequest){
        EmployeeResponse employeeResponse = employeeServices.addEmployee(employeeRequest);
        return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
    }

    @GetMapping ("/employee/{id}")
    public ResponseEntity<EmployeeResponse> searchEmployee(@PathVariable("id") Long id){
        return employeeServices.findEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping ("/employee")
    public ResponseEntity<List<EmployeeResponse>> displayEmployee(){
        return ResponseEntity.ok(employeeServices.displayAllEmployees());
    }

    @PutMapping ("/employee/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable("id") Long id,@Valid @RequestBody EmployeeRequest employeeRequest){
        return ResponseEntity.ok(employeeServices.updateEmployee(id, employeeRequest));
    }

    @DeleteMapping ("/employee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id){
        employeeServices.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
