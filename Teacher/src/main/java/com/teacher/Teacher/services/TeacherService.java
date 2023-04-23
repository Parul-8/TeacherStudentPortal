package com.teacher.Teacher.services;

import com.teacher.Teacher.beans.TeacherDetails;


public interface TeacherService {
	
	
	public TeacherDetails createTeacher(TeacherDetails teacher);
	
	public TeacherDetails geTeacherDetails(Integer tId);
	

}
