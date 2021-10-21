package com.example.mspersonnel;

import com.example.mspersonnel.entities.Employee;
import com.example.mspersonnel.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsPersonnelApplication implements CommandLineRunner
{

    @Autowired
    private EmployeeService employeeService;
    public static void main(String[] args) {
        SpringApplication.run(MsPersonnelApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeService.saveEmployee(new Employee(null, "OMARI", "Hamza", "omari@gmail.com"));
        employeeService.saveEmployee(new Employee(null, "HARRAR", "SeifEddine", "harrar@gmail.com"));
        employeeService.saveEmployee(new Employee(null, "ELMIR", "Yacine", "elmir@gmail.com"));

        employeeService.getAllEmployee().forEach(e ->{
            System.out.println(e.toString());
        } );
    }
}
