package com.example.Services;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;


import com.example.Model.Student;

@Repository
public interface StudentService {
    
 public void addStudent(Student st)throws SQLException;
}
