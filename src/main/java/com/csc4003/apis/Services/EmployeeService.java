package com.csc4003.apis.Services;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import com.csc4003.apis.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csc4003.apis.Repositories.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        List<Employee> employeeRecords = new ArrayList<>();
        employeeRepository.findAll().forEach(employeeRecords::add);
        return employeeRecords;
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployeeById(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Optional<Employee> findEmployeeById(int employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public List<Employee> findByFullName(String fullName) {
        return employeeRepository.findByFullName(fullName);
    }
}

