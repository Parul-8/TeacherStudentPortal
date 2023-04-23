package com.teacher.Teacher.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teacher.Teacher.beans.TeacherDetails;
import com.teacher.Teacher.repositories.TeacherRepository;
import com.teacher.Teacher.services.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	
	@Autowired
	TeacherRepository teacherRepo;
	
//	@Autowired
//	PasswordEncoder passwordEncoder;
	
	
	@Override
	public TeacherDetails createTeacher(TeacherDetails teacher) {
		
		TeacherDetails savedTeacherDetails = this.teacherRepo.save(teacher);
		
		return savedTeacherDetails;
	}

	@Override
	public TeacherDetails geTeacherDetails(Integer tId) {
		//Optional<TeacherDetails> teacher = this.teacherRepo.findById(tId);
		Optional<TeacherDetails> teacher = this.teacherRepo.findById(tId);
		TeacherDetails tDetails = teacher.get();
		return tDetails;
	}
	
	
	
	
	

}
