package com.springsql.Repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springsql.Model.Student;

@Repository
public class StudentRepo {

    List<Student> list =new ArrayList<>();
    public void add(Student student){

        list.add(student);
        
    }
}
