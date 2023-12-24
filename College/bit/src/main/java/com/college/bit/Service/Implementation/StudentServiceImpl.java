package com.college.bit.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.bit.Model.Student;
import com.college.bit.Repo.StudentRepo;
import com.college.bit.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepo repo;

    @Override
    public Student create(Student st) {
        return repo.save(st);
    }
    @Override
    public Student fetchStudentById(int id){
        return repo.findById(id).orElse(null);
    }
    

    
}
