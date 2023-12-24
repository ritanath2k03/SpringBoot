package com.springsql.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity

@Table(name="students")
public class Student {
    
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "roll")
    private long roll;

    @Column(name = "dept")
    private String dept;

    public Student() {
    }
    
    public Student(int id, String name, int age, long roll, String dept) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.roll = roll;
        this.dept = dept;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public long getRoll() {
        return roll;
    }
    public void setRoll(long roll) {
        this.roll = roll;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }


}
