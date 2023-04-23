package com.teacher.Teacher.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teacher.Teacher.beans.TeacherDetails;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherDetails, Integer> {
	
	Optional<TeacherDetails> findByEmail(String email);

}
