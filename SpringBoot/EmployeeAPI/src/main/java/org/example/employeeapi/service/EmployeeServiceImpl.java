package org.example.employeeapi.service;

import jakarta.transaction.Transactional;
import org.example.employeeapi.entity.Employee;
import org.example.employeeapi.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

//    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAllEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee,long id) {
        Employee e = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        e.setName(employee.getName());
        e.setAge(employee.getAge());
        e.setPost(employee.getPost());
        return employeeRepository.save(e);
    }

    @Override
    public void deleteEmployee(long id) {
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        }
    }
}
