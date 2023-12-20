package com.springsql.dao;

import com.springsql.model.Employee;

public interface EmployeeDAO {
    java.util.List<Employee> get();
    Employee get(int id);
    void save(Employee employee);
    void delete(int id);
    
}
