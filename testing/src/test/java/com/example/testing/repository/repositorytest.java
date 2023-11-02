package com.example.testing.repository;


import com.example.testing.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class repositorytest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testFindByEmail() {
        Employee employee = new Employee("John", "Doe", "Womanczczzczx", 5000.0);
        employeeRepository.save(employee);


        Employee foundEmployee = employeeRepository.findByEmail("Womanczczzczx");

        assertNotNull(foundEmployee);
        assertEquals("Womanczczzczx", foundEmployee.getEmail());
    }

    @Test
    public void testFindBySalary() {
        employeeRepository.save(new Employee("Alice", "Johnson", "alice@example.com", 4500.0));
        employeeRepository.save(new Employee("Bob", "Smith", "bob@example.com", 6000.0));
        employeeRepository.save(new Employee("Eve", "Brown", "eve@example.com", 2089));

        List<Employee> employees = employeeRepository.findBySalary(2089);

        assertEquals(1, employees.size());
    }

    @Test
    public void testFindAllByOrderByLastName() {
        Employee lowestLastNameEmployee = employeeRepository.findAllByOrderByLastName().get(0);

        employeeRepository.save(new Employee("David", "Kemal", "david@example.com", 4800.0));
        employeeRepository.save(new Employee("Alice", "Baker", "alice@example.com", 5500.0));

        List<Employee> employees = employeeRepository.findAllByOrderByLastName();

        assertEquals(lowestLastNameEmployee.getLastName(), employees.get(0).getLastName());
    }
}
