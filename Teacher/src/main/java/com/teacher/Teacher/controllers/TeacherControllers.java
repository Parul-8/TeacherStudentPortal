package com.teacher.Teacher.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teacher.Teacher.beans.StudentDetails;
import com.teacher.Teacher.beans.StudentResponse;
import com.teacher.Teacher.beans.TeacherDetails;
import com.teacher.Teacher.services.StudentService;
import com.teacher.Teacher.services.TeacherService;

@RestController
public class TeacherControllers {
	

	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/homee")
	public String home() {
		return "welcome";
	}
	
	
	@PostMapping("/addTeacherDetails")
	public ResponseEntity<TeacherDetails> createTeacher(@Valid @RequestBody TeacherDetails teacher){
		teacher.setPassword(bCryptPasswordEncoder.encode(teacher.getPassword()));
		TeacherDetails teacherSaved = this.teacherService.createTeacher(teacher);
		return new ResponseEntity<>(teacherSaved,HttpStatus.CREATED);
	}
	
	@GetMapping("/teacher/{tId}")
	public ResponseEntity<TeacherDetails> getTeacherDetails(@PathVariable("tId") Integer tId){
		
		return ResponseEntity.ok(teacherService.geTeacherDetails(tId));
		
	}
	
	/* add student details */
	@PostMapping("/addStudent")
	public ResponseEntity<StudentDetails> addStudent(@RequestBody StudentDetails student) {
		
		StudentDetails studentSaved = this.studentService.createStudent(student);
		return new ResponseEntity<>(student,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/student/{rollNo}")
	public ResponseEntity<StudentDetails> getStudentByRollNo(@PathVariable("rollNo") Integer rollNo){
		
		return ResponseEntity.ok(studentService.getStudentByRollNo(rollNo));
		
	}
	
	@GetMapping("/allStudents")
	public ResponseEntity<StudentResponse> getAllStudents(
			@RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize){
		StudentResponse studentResponse = this.studentService.getAllStudents(pageNumber, pageSize);
		return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.OK);
	}

}
