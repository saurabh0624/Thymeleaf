package com.demo.thymleaf.service;

import com.demo.thymleaf.model.Employee;
import com.demo.thymleaf.repository.EmployeeRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if(optional.isPresent())
            employee = optional.get();
        else
            throw new RuntimeException("Employee not found for id: " + id);

        return employee;
    }

    public void deleteEmployeeById(long id) {

        employeeRepository.deleteById(id);
    }
}
