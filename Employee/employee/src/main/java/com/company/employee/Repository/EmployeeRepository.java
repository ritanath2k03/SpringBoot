package com.company.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.employee.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    
}
