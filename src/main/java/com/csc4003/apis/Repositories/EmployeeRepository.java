package com.csc4003.apis.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.csc4003.apis.models.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>
{
    Employee findByEmail(String email);
    List<Employee> findByFullName(String fullName);

}

