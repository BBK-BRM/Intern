package com.example.employeemanagementsystem.services.impl;

import com.example.employeemanagementsystem.entity.EmployeeEntity;
import com.example.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.example.employeemanagementsystem.payload.request.EmployeeRequest;
import com.example.employeemanagementsystem.payload.response.EmployeeResponse;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import com.example.employeemanagementsystem.services.EmployeeServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServicesImpl implements EmployeeServices {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addEmployee(EmployeeRequest employeeRequest) {
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .name(employeeRequest.getName())
                .age(employeeRequest.getAge())
                .post(employeeRequest.getPost())
                .build();

//        EmployeeEntity employeeEntity = modelMapper.map(employeeRequest,EmployeeEntity.class);

        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
//        EmployeeResponse response = modelMapper.map(savedEmployeeEntity,EmployeeResponse.class);
//        return response;
    }

    @Override
    public List<EmployeeResponse> displayAllEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        List<EmployeeResponse> employeeResponseList = employeeEntityList.stream()
//                .filter(employeeEntity -> employeeEntity.getAge()>20)
                .map(employee -> modelMapper.map(employee,EmployeeResponse.class))
                .toList();
        return employeeResponseList;
    }

//    @Override
//    public Page<EmployeeResponse> displayAllEmployees(int page,int size,String sortBy,boolean ascending) {
//        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
//        Pageable pageable = PageRequest.of(page,size,sort);
//        Page<EmployeeEntity> employees = employeeRepository.findAll(pageable);
//        Page<EmployeeResponse> response = employees.map(employee -> modelMapper.map(employee, EmployeeResponse.class));//        for(EmployeeEntity employee : employees){
//
////            EmployeeResponse response = modelMapper.map(employee,EmployeeResponse.class);
////            responses.add(response);
////        }
//
//        return response;
//    }

    @Override
    public EmployeeResponse findEmployeeById(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() ->new EmployeeNotFoundException("Employee not found by id : " +id));
        EmployeeResponse response = modelMapper.map(employee,EmployeeResponse.class);
        return response;
    }

    @Override
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest employeeRequest) {
        EmployeeEntity Employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found by id : " +id));
        Employee.setName(employeeRequest.getName());
        Employee.setAge(employeeRequest.getAge());
        Employee.setPost(employeeRequest.getPost());
//        employeeRepository.save(Employee);

        EmployeeEntity updatedEmployee = employeeRepository.save(Employee);
        EmployeeResponse response = modelMapper.map(updatedEmployee,EmployeeResponse.class);
        return response;

//        modelMapper.map(employeeRequest,existingEmployee);
//        return  modelMapper.map(employeeRepository.save(existingEmployee));
    }

    @Override
    public void deleteEmployee(Long id) {
        if(!employeeRepository.existsById(id)){
            throw new EmployeeNotFoundException("Cannot Delete as Employee not found by id :"+id);
        }
        employeeRepository.deleteById(id);
    }
}
