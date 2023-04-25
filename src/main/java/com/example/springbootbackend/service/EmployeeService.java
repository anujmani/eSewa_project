package com.example.springbootbackend.service;

import com.example.springbootbackend.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAll(Employee employee);
    Employee getById(long id);
    Employee update(Employee employee,long id);
    void delete(long id);
}
