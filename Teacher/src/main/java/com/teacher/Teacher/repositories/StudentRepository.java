package com.teacher.Teacher.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teacher.Teacher.beans.StudentDetails;
import com.teacher.Teacher.beans.TeacherDetails;

public interface StudentRepository extends JpaRepository<StudentDetails, Integer> {
	
	Optional<StudentDetails> findByRollNo(Integer rollNo);

}
