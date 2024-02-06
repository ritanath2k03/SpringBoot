package com.company.employee.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.employee.Model.Employee;
import com.company.employee.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation  implements EmployeeService{

    @Autowired
    EmployeeRepository repo;
    @Override
    public Employee insertEmployee(Employee employee) {
        
        Employee savedEmployee=repo.save(employee);
        
        return savedEmployee;
    }
    
}
