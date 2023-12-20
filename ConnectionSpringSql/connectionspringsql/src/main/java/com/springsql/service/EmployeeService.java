package com.springsql.service;

import com.springsql.model.Employee;

public interface EmployeeService {
    java.util.List<Employee> get();
    Employee get(int id);
    void save(Employee employee);
    void delete(int id);
    
}
