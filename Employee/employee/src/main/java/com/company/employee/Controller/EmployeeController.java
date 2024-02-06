package com.company.employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.employee.Model.Employee;
import com.company.employee.Service.EmployeeService;

@RestController

public class EmployeeController {

    @Autowired
    public final EmployeeService service ;
  
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/insert")
    public Employee addEmployee(@RequestBody Employee e){
        System.out.println(e.getName()+" "+e.getPriority()+" "+e.getBranch());
        return  service.insertEmployee(e);
    }

}


