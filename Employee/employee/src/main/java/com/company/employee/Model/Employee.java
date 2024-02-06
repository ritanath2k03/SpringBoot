package com.company.employee.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String branch;
    @Column
    private int priority;
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getBranch() {
        return branch;
    }
    public int getPriority() {
        return priority;
    }
    @Override
    public String toString() {
        return "Employee [Id=" + id + ", name=" + name + ", branch=" + branch + ", priority=" + priority + "]";
    }
  
  

        
}
