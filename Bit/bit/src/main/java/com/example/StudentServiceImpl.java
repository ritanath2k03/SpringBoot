package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.example.Model.Student;
import com.example.Services.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
   
    Connection connection;
    public StudentServiceImpl() throws SQLException  {
        // TODO Auto-generated method stub
       connection= DBUtils.getConnection();
    }
    @Override
    public void addStudent(Student s){
        String name=s.getName();
        String dept=s.getDepartment();
        String age=s.getAge();
        int id=s.getId();
        String roll=s.getRoll();
        String query="INSERT INTO bit_student VALUES("+id+",'"+name+"','"+age+"','"+dept+"','"+roll+"');";
        System.out.println("Working");
        try {
            System.out.println("insider try");
            PreparedStatement stmt=connection.prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("Data Added");
        } catch (SQLException e) {
            System.out.println("inside catch");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    
}
