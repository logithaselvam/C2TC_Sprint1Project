package com.mall.employeeservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mall.employeeservice.entity.Employee;
import com.mall.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    // CREATE
    @Override
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    // READ ALL
    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // READ BY ID
    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id : " + id));
    }

    // UPDATE
    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id : " + id));

        existingEmployee.setName(employee.getName());
        existingEmployee.setRole(employee.getRole());
        existingEmployee.setSalary(employee.getSalary());
       
        return repository.save(existingEmployee);
    }

    // DELETE
    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
