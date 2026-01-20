package com.example.employeemanagementsystem.services.impl;

import com.example.employeemanagementsystem.entity.EmployeeEntity;
import com.example.employeemanagementsystem.payload.request.EmployeeRequest;
import com.example.employeemanagementsystem.payload.response.EmployeeResponse;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import com.example.employeemanagementsystem.services.EmployeeServices;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    @Transactional
    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeRequest,EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity,EmployeeResponse.class);
    }

    @Override
    public List<EmployeeResponse> displayAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        List<EmployeeResponse> responses = new ArrayList<>();
        for(EmployeeEntity employee : employees){
            EmployeeResponse response = modelMapper.map(employee,EmployeeResponse.class);
            responses.add(response);
        }
        return responses;
    }

    @Override
    public Optional<EmployeeResponse> findEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(employee -> modelMapper.map(employee,EmployeeResponse.class));
    }

    @Override
    @Transactional
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest employeeRequest) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found by id : " +id));
        existingEmployee.setName(employeeRequest.getName());
        existingEmployee.setAge(employeeRequest.getAge());
        existingEmployee.setPost(employeeRequest.getPost());

        EmployeeEntity updatedEmployee = employeeRepository.save(existingEmployee);
        return modelMapper.map(updatedEmployee,EmployeeResponse.class);

//        modelMapper.map(employeeRequest,existingEmployee);
//        return  modelMapper.map(employeeRepository.save(existingEmployee));
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        if(!employeeRepository.existsById(id)){
            throw new RuntimeException("Cannot Delete: Employee not found by id :"+id);
        }
        employeeRepository.deleteById(id);
    }
}
