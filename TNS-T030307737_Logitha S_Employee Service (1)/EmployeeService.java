package com.mall.employeeservice.service;

import java.util.List;

import com.mall.employeeservice.entity.Employee;

public interface EmployeeService {

    // CREATE
    Employee addEmployee(Employee employee);

    // READ ALL
    List<Employee> getAllEmployees();

    // READ BY ID
    Employee getEmployeeById(Long id);

    // UPDATE
    Employee updateEmployee(Long id, Employee employee);

    // DELETE
    void deleteEmployee(Long id);
}












