package com.example;

import java.sql.Connection;

import java.sql.SQLException;

public class DBUtils {
    private static Connection connection=null;
   
    public static Connection getConnection() throws SQLException{
        if(connection!=null)return connection;
        else{
            String driver="com.mysql.cj.jdbc.Driver";
            String url="jdbc:mysql://localhost/bitstudent?useSSL=false";
            String user="root";
            String password="Rith-sql@2003";
           try{ Class.forName(driver);
            return connection = java.sql.DriverManager.getConnection(url,user,password);
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
            return connection;
        }
    }
    
}
