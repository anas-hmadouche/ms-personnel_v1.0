package com.example.mspersonnel.repos;

import com.example.mspersonnel.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
