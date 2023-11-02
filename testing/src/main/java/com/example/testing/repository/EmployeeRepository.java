package com.example.testing.repository;

import com.example.testing.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee findByEmail(String email);

    List<Employee> findBySalary(double salary);

    List<Employee> findAllByOrderByLastName();
}

