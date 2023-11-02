package com.example.testing.service;

import com.example.testing.repository.EmployeeRepository;
import com.example.testing.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public List<Employee> findBySalary(double salary) {
        return employeeRepository.findBySalary(salary);
    }

    @Override
    public List<Employee> findByOrder() {
        return employeeRepository.findAllByOrderByLastName();
    }
}