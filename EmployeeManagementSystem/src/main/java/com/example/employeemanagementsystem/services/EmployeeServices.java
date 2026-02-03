package com.example.employeemanagementsystem.services;

import com.example.employeemanagementsystem.entity.EmployeeEntity;
import com.example.employeemanagementsystem.payload.request.EmployeeRequest;
import com.example.employeemanagementsystem.payload.response.EmployeeResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EmployeeServices {
    void addEmployee(EmployeeRequest employeeRequest);
    List<EmployeeResponse> displayAllEmployees();
//    Page<EmployeeResponse> displayAllEmployees(int page,int size,String sortBy,boolean ascending);
    EmployeeResponse findEmployeeById(Long id);
    EmployeeResponse updateEmployee(Long id,EmployeeRequest employeeRequest);
    void deleteEmployee(Long id);
}
