package com.teacher.Teacher.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class StudentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rollNo;
	
	private String name;
	
	private String dept;
	
	private String standard;
	
	private Integer age;
	
	private String gender;

	public StudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDetails(Integer rollNo, String name, String dept, String standard, Integer age, String gender) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.dept = dept;
		this.standard = standard;
		this.age = age;
		this.gender = gender;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
