package com.teacher.Teacher.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.teacher.Teacher.beans.StudentDetails;
import com.teacher.Teacher.beans.StudentResponse;
import com.teacher.Teacher.repositories.StudentRepository;
import com.teacher.Teacher.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepo;
	

	@Override
	public StudentDetails createStudent(StudentDetails student) {
		
		StudentDetails savedStudent = this.studentRepo.save(student);
		return savedStudent;
	}


	@Override
	public StudentDetails getStudentByRollNo(Integer rollNo) {
		StudentDetails student = this.studentRepo.getById(rollNo);
		return student;
	}


	@Override
	public StudentResponse getAllStudents(Integer pageNumber, Integer pageSize) {
		
		 PageRequest p = PageRequest.of(pageNumber, pageSize);

	     Page<StudentDetails> pageStudent = this.studentRepo.findAll(p);

	     List<StudentDetails> allStudents = pageStudent.getContent();
		//StudentResponse studentList = this.studentRepo.findAll(null, null)
	     
	 
	     
	     StudentResponse studentResponse = new StudentResponse();
	     
			studentResponse.setContent(allStudents);
			studentResponse.setPageNumber(pageStudent.getNumber());
			studentResponse.setPageSize(pageStudent.getSize());
			studentResponse.setTotalElements(pageStudent.getTotalElements());

			studentResponse.setTotalPages(pageStudent.getTotalPages());
			studentResponse.setLastPage(pageStudent.isLast());

			return studentResponse;
		}


	@Override
	public StudentDetails updateStudents(StudentDetails student) {
		StudentDetails savedStudent = this.studentRepo.save(student);
		return savedStudent;
	}

}
