package com.springsql.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.springsql.Model.Student;
import com.springsql.Repo.StudentRepo;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    StudentRepo repo;

    @Override
    @Bean
    public void addStudent(Student student) {
        // TODO Auto-generated method stub
        System.out.println("Inside the Service Layer");
        repo.add(student);
    }

    
    
}
