package com.college.bit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.bit.Model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{
    
}
