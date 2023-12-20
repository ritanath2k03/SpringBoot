package com.springsql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsql.model.Employee;
import com.springsql.service.EmployeeService;

@RequestMapping("/api")
@RestController 
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
  
    @GetMapping("/employee")
    public List<Employee> get(){

       return  employeeService.get();

    }
}
