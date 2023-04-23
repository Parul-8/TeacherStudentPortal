package com.teacher.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.bytebuddy.asm.Advice.This;

@SpringBootApplication
public class TeacherApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(TeacherApplication.class, args);
		
	}

}
