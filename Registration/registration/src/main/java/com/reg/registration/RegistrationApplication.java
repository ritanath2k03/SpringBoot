package com.reg.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RegistrationApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(RegistrationApplication.class, args);
	}

}
