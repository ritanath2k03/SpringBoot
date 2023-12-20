package com.springsql.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="table_employee")
public class Employee {
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
   private Integer id;
   @Column
   private String name;
   @Column
   private String gender;
   @Column
    private String depertment;
    @Column
    private Date dob;
    public Employee(String name, String gender, String depertment, Date dob) {
        this.name = name;
        this.gender = gender;
        this.depertment = depertment;
        this.dob = dob;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getDepertment() {
        return depertment;
    }
    public void setDepertment(String depertment) {
        this.depertment = depertment;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", depertment=" + depertment + ", dob="
                + dob + "]";
    }

    
}
