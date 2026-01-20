package com.example.employeemanagementsystem.services;

import com.example.employeemanagementsystem.entity.EmployeeEntity;
import com.example.employeemanagementsystem.payload.request.EmployeeRequest;
import com.example.employeemanagementsystem.payload.response.EmployeeResponse;

import java.util.List;
import java.util.Optional;

public interface EmployeeServices {
    EmployeeResponse addEmployee(EmployeeRequest employeeRequest);
    List<EmployeeResponse> displayAllEmployees();
    Optional<EmployeeResponse> findEmployeeById(Long id);
    EmployeeResponse updateEmployee(Long id,EmployeeRequest employeeRequest);
    void deleteEmployee(Long id);
}
