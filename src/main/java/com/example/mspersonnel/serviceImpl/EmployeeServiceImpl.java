package com.example.mspersonnel.serviceImpl;
import com.example.mspersonnel.entities.Employee;
import com.example.mspersonnel.repos.EmployeeRepository;
import com.example.mspersonnel.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) throws ResourceNotFoundException {
        Employee employee=employeeRepository.findById(id).get();
        if(employee==null) throw new RuntimeException("Employée innexistant!!");
        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee editEmployee(Long id, Employee employeeDetails) {
        employeeDetails.setId(id);
        final Employee updateEmployee=employeeRepository.save(employeeDetails);
        return updateEmployee;
    }

    @Override
    public Map<String, Boolean> deleteEmployee(Long id) {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employée non trouvé"));
        employeeRepository.delete(employee);
        System.out.println("L'employée est supprimé avec succées");
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
