package com.college.bit.Service;

import org.springframework.stereotype.Service;

import com.college.bit.Model.Student;

@Service
public interface StudentService {
  
        Student create(Student st);

        Student fetchStudentById(int id);
}
