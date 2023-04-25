package com.example.springbootbackend.controller;

import com.example.springbootbackend.entity.Employee;
import com.example.springbootbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }
    //save the employee
    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    //get all the employee
    @GetMapping("/employees")
    public List<Employee> getAll(Employee employee){
        return employeeService.getAll(employee);
    }
    //get specific employee
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") long id){
        return new ResponseEntity<Employee>(employeeService.getById(id),HttpStatus.OK);
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") long id, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.update(employee,id),HttpStatus.OK);
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String>delete(@PathVariable("id") long id){
        employeeService.delete(id);
        return new ResponseEntity<String>("Id has be deleted",HttpStatus.OK);
    }
//    @GetMapping("/employee/{id}")
//    public ResponseEntity<Employee> getById(Employee employee){
//        return new ResponseEntity<Employee>(employeeService.getById(employee.getId()),HttpStatus.OK);
//    }
}
