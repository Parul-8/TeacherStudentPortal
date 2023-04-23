package com.teacher.Teacher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teacher.Teacher.beans.StudentDetails;

public interface StudentRepository extends JpaRepository<StudentDetails, Integer> {

}
