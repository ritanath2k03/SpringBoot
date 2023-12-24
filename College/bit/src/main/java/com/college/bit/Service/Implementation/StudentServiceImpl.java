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
        Student createdStudent=repo.save(st);
        return createdStudent;
    }
    @Override
    public Student fetchStudentById(int id){
        return repo.findById(id).orElse(null);
    }
    @Override
    public Student updateStudent(Student student){
        Student updatest=repo.findById(student.getId()).orElse(null);
        if(updatest!=null){
            updatest.setId(student.getId());
            updatest.setName(student.getName());
            
            repo.save(updatest);
            System.out.println("Updated");
            return updatest;
        }
        return null;
    }
  

    
}
