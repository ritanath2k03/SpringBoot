package com.springsql.Service;

import com.springsql.Model.Student;

public interface StudentService{
    void addStudent(Student student);

    com.springsql.crudsql.Controller.Student addStudent(com.springsql.crudsql.Controller.Student student);
}
