package com.springsql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsql.dao.EmployeeDAO;
import com.springsql.model.Employee;
@Service
public class EmployeeServiceImplement implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Transactional
    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        
    }

    @Transactional
    @Override
    public List<Employee> get() {
     return (List<Employee>) employeeDAO.get();
     
    }
    @Transactional
    @Override
    public Employee get(int id) {
        // TODO Auto-generated method stub
        return null;
    }
    @Transactional
    @Override
    public void save(Employee employee) {
        // TODO Auto-generated method stub
        
    }
    
}
