package org.example.employeeapi.controller;

import org.example.employeeapi.entity.Employee;
import org.example.employeeapi.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

//    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping ("/")
    public String home() {
        return "Home Page";
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/search/{id}")
    public Optional<Employee> searchEmployee(@PathVariable("id") int userId) {
        return employeeService.findEmployeeById(userId);
    }

    @GetMapping("/display")
    public List<Employee> displayEmployee() {
        return employeeService.findAllEmployee();
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable("id") int userId,@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee,userId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int userId) {
        employeeService.deleteEmployee(userId);
        return "delete Employee successfully";
    }
}
