package com.springsql.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springsql.model.Employee;
import java.util.List;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImplement implements EmployeeDAO{
    @Autowired
    private EntityManager entityManager;

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Employee> get() {
      Session currentSession= entityManager.unwrap(Session.class);
      Query<Employee> query= currentSession.createQuery("from Employee",Employee.class);
       java.util.List<Employee> list=  query.getResultList();
        return list;
    }

    @Override
    public Employee get(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Employee employee) {
        // TODO Auto-generated method stub
        
    }
    
}
