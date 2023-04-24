package com.teacher.Teacher.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.teacher.Teacher.beans.StudentDetails;
import com.teacher.Teacher.beans.StudentResponse;
import com.teacher.Teacher.exceptions.ResourceAlreadyExistException;
import com.teacher.Teacher.exceptions.ResourceNotFoundException;
import com.teacher.Teacher.repositories.StudentRepository;
import com.teacher.Teacher.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepo;
	

	@Override
	public StudentDetails createStudent(StudentDetails student) {
		Optional<StudentDetails> optional = this.studentRepo.findByRollNo(student.getRollNo());
		
		if(optional.isPresent()) {
			
			throw new ResourceAlreadyExistException("Student", "RollNo", student.getRollNo().toString());
			
		}
		
		StudentDetails savedStudent = this.studentRepo.save(student);
		return savedStudent;
	}


	@Override
	public StudentDetails getStudentById(Integer id) {
		StudentDetails student = this.studentRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", " id ", id));
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
	public StudentDetails updateStudent(StudentDetails student) {
		this.studentRepo.findByRollNo(student.getRollNo())
				.orElseThrow(() -> new ResourceNotFoundException("Student", "RollNo", student.getRollNo()));
		StudentDetails savedStudent = this.studentRepo.save(student);
		return savedStudent;
	}

}
