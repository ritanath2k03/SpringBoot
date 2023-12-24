package com.springsql.crudsql;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springsql.Model.Student;

@SpringBootApplication
// @Configuration
public class CrudsqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudsqlApplication.class, args);
	}
	
	// @Bean
	// public Student student(){
	// 	return new Student();
	// }



}
