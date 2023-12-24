package com.college.bit.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.bit.Model.Student;
import com.college.bit.Service.StudentService;

@RestController
@RequestMapping("/bit")
public class StudentController {
    @Autowired
    private final StudentService sr;

    @Autowired
    public StudentController(StudentService service){
        this.sr=service;
    }
    @PostMapping("/create")
    public Student saveStudent(@RequestBody Student st){
       
return sr.create(st);
    }
}
