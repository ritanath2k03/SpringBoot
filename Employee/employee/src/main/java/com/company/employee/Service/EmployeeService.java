package com.company.employee.Service;

import org.springframework.stereotype.Service;

import com.company.employee.Model.Employee;

@Service
public interface EmployeeService {
    Employee insertEmployee(Employee employee);
}
