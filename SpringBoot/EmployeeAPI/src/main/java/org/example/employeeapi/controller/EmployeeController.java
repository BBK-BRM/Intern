package org.example.employeeapi.controller;

import org.example.employeeapi.entity.Employee;
import org.example.employeeapi.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

//    @Autowired
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeService){
        this.employeeServiceImpl = employeeService;
    }

    @GetMapping ("/")
    public String home() {
        return "Home Page";
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeServiceImpl.addEmployee(employee);
    }

    @GetMapping("/search/{id}")
    public Optional<Employee> searchEmployee(@PathVariable("id") int userId) {
        return employeeServiceImpl.findEmployeeById(userId);
    }

    @GetMapping("/display")
    public List<Employee> displayEmployee() {
        return employeeServiceImpl.findAllEmployee();
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable("id") int userId,@RequestBody Employee employee) {
        return employeeServiceImpl.updateEmployee(employee,userId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int userId) {
        employeeServiceImpl.deleteEmployee(userId);
        return "delete Employee successfully";
    }
}
