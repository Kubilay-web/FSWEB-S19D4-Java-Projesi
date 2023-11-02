package com.example.testing.service;

import com.example.testing.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Employee getEmployeeById(Long id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Long id);
    Employee findByEmail(String email);
    List<Employee> findBySalary(double salary);
    List<Employee> findByOrder();
}
