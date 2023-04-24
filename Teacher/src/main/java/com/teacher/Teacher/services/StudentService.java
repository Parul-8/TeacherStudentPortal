package com.teacher.Teacher.services;

import java.util.List;

import com.teacher.Teacher.beans.StudentDetails;
import com.teacher.Teacher.beans.StudentResponse;

public interface StudentService {
	
	public StudentDetails createStudent(StudentDetails student);
	
	public StudentDetails updateStudent(StudentDetails student);
	
	public StudentDetails getStudentById(Integer id);
	
	public StudentResponse getAllStudents(Integer pageNumber,Integer pageSize);

}
