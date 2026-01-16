package org.example.employeeapi.service;

import org.example.employeeapi.entity.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAllEmployee();
    Optional<Employee> findEmployeeById(long id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee,long id);
    void deleteEmployee(long id);
}
