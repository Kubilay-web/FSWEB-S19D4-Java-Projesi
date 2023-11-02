package com.example.testing.controller;


import com.example.testing.entity.Employee;
import com.example.testing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/byEmail/{email}")
    public Employee getEmployeeByEmail(@PathVariable String email) {
        return employeeService.findByEmail(email);
    }

    @GetMapping("/byOrder")
    public List<Employee> getEmployeesByOrder() {
        return employeeService.findByOrder();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/bySalary/{salary}")
    public List<Employee> getEmployeesBySalary(@PathVariable double salary) {
        return employeeService.findBySalary(salary);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}