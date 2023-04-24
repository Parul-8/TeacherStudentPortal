package com.teacher.Teacher.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="TEACHER")
public class TeacherDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer tId;
	
	private String name;
	
	private String username;
	
	@Column(unique = true)
	@Email(message = "Email should be in proper format!!!")
	private String email;
	
	private String password;
	
	@Min(value = 18, message = "Age must not be less than 18.")
	@Max(value = 100, message = "Age must not be greater than 100.")
	private Integer age;
	
	private String gender;
	
	private String role="ROLE_USER";
	
	

	public TeacherDetails(Integer tId, String name, String username, String email, String password, Integer age,
			String gender, String role) {
		super();
		this.tId = tId;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.role = role;
	}



	public TeacherDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public TeacherDetails(Integer tId, String name, String username, String email, String password, Integer age,
			String gender) {
		super();
		this.tId = tId;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.age = age;
		this.gender = gender;
	}



	public Integer gettId() {
		return tId;
	}

	public void settId(Integer tId) {
		this.tId = tId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
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



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	

}
