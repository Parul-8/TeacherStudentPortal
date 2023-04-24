package com.teacher.Teacher.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teacher.Teacher.beans.TeacherDetails;
import com.teacher.Teacher.exceptions.ResourceAlreadyExistException;
import com.teacher.Teacher.exceptions.ResourceNotFoundException;
import com.teacher.Teacher.repositories.TeacherRepository;
import com.teacher.Teacher.services.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	
	@Autowired
	TeacherRepository teacherRepo;
	
	
	@Override
	public TeacherDetails createTeacher(TeacherDetails teacher) {
		
		Optional<TeacherDetails> optional = this.teacherRepo.findByEmail(teacher.getEmail());
		
		if(optional.isPresent()) {
			
			throw new ResourceAlreadyExistException("Teacher", "Email", teacher.getEmail().toString());
			
		}
		
		TeacherDetails savedTeacherDetails = this.teacherRepo.save(teacher);
		
		return savedTeacherDetails;
	}

	@Override
	public TeacherDetails geTeacherDetails(Integer tId) {
		TeacherDetails teacher = this.teacherRepo.findById(tId)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher", " Id ", tId));
		
		return teacher;
	}
	
	
	
	
	

}
