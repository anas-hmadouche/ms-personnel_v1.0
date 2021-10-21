package com.example.mspersonnel.controller;

import com.example.mspersonnel.entities.Employee;
import com.example.mspersonnel.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/employees",produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Employee> getAllEmployees() {
        return new ResponseEntity(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getByIdProduit(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee createConge(@Validated @RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> updateEmployees(@PathVariable(value = "id") Long id,
                                                    @Validated @RequestBody Employee employeeDetails)
            throws ResourceNotFoundException {
        employeeDetails.setId(id);
        final Employee updateEmployee = employeeService.editEmployee(id, employeeDetails);
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteConges(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        return employeeService.deleteEmployee(id);
    }
}