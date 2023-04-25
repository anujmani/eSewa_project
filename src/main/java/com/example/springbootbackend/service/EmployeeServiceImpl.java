package com.example.springbootbackend.service;

import com.example.springbootbackend.entity.Employee;
import com.example.springbootbackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll(Employee employee) {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee update(Employee employee, long id) {
        Employee existEmployee=employeeRepository.findById(id).get();
        existEmployee.setFirstName(employee.getFirstName());
        existEmployee.setLastName(employee.getLastName());
        existEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existEmployee);
        return existEmployee;
    }

    @Override
    public void delete( long id) {

        employeeRepository.deleteById(id);
    }

}
