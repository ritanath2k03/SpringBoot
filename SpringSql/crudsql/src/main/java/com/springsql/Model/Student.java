package com.springsql.Model;

import org.springframework.stereotype.Repository;


public class Student {
    
    private int id;

    private String name;
    private int age;
    private long roll;
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
