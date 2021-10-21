package com.example.mspersonnel.services;

import com.example.mspersonnel.entities.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public List<Employee> getAllEmployee();

    public Employee getEmployeeById(Long id);

    public Employee saveEmployee(Employee employee);

    public Employee editEmployee(Long id, Employee employeeDetails);

    public Map<String, Boolean> deleteEmployee(Long id);
}
