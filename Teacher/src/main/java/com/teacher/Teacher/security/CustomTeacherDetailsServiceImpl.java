package com.teacher.Teacher.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.teacher.Teacher.beans.TeacherDetails;
import com.teacher.Teacher.repositories.TeacherRepository;


@Service
public class CustomTeacherDetailsServiceImpl implements UserDetailsService {

	@Autowired
	TeacherRepository teacherRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<TeacherDetails> teacherDetails = this.teacherRepository.findByEmail(username);
		/*
		 * if(teacherDetails == null) { throw new
		 * UsernameNotFoundException("Could not found user");
		 * 
		 * }
		 */
		if(teacherDetails == null) {
			throw new UsernameNotFoundException("Could not found user !!");
		}
		TeacherDetails tDetails = teacherDetails.get();
		
		CustomTeacherDetails customTeacherDetails = new CustomTeacherDetails(tDetails);
		
		return customTeacherDetails;
	}  

}
