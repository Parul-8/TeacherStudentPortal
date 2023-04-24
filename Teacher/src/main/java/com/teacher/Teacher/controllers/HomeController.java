package com.teacher.Teacher.controllers;

import java.util.List;

import javax.persistence.criteria.Fetch;
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
public class HomeController {
	

	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/* Api for testing  */
	@GetMapping("/homee")
	public String home() {
		return "welcome HOME!!";
	}
	
	/* for registering teacher details */
	@PostMapping("/teacher/signUp")
	public ResponseEntity<TeacherDetails> createTeacher(@Valid @RequestBody TeacherDetails teacher){
		teacher.setPassword(bCryptPasswordEncoder.encode(teacher.getPassword()));
		TeacherDetails teacherSaved = this.teacherService.createTeacher(teacher);
		return new ResponseEntity<>(teacherSaved,HttpStatus.CREATED);
	}
	
	/* to fetch teacher details using id */
	@GetMapping("/teacher/{tId}")
	public ResponseEntity<TeacherDetails> getTeacherDetails(@PathVariable("tId") Integer tId){
		
		return ResponseEntity.ok(teacherService.geTeacherDetails(tId));
		
	}
	
	/* add student details */
	@PostMapping("/student/add")
	public ResponseEntity<StudentDetails> addStudent(@RequestBody StudentDetails student) {
		
		StudentDetails studentSaved = this.studentService.createStudent(student);
		return new ResponseEntity<>(student,HttpStatus.CREATED);
		
	}
	
	/* update student details */
	@PostMapping("/student/update")
	public ResponseEntity<StudentDetails> updateStudent(@RequestBody StudentDetails student) {
		
		StudentDetails studentSaved = this.studentService.updateStudent(student);
		return new ResponseEntity<>(student,HttpStatus.CREATED);
		
	}
	
	/* Fetch studentFetch details using id */
	@GetMapping("/student/{id}")
	public ResponseEntity<StudentDetails> getStudentById(@PathVariable("id") Integer sId){
		
		return ResponseEntity.ok(studentService.getStudentById(sId));
		
	}
	
	/* Fetch all student details with proper pagination */
	@GetMapping("/student/all")
	public ResponseEntity<StudentResponse> getAllStudents(
			@RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize){
		StudentResponse studentResponse = this.studentService.getAllStudents(pageNumber, pageSize);
		return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.OK);
	}

}
