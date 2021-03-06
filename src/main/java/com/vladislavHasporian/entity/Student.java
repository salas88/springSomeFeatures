package com.vladislavHasporian.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	
	@NotNull
	@Size(min=5, message="is required")
	private String LastName;
	
	@NotNull(message="must be set")
	@Email
	private String email;
	
	@OneToMany(mappedBy="student", cascade= {CascadeType.DETACH, CascadeType.MERGE,
											 CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Course> courses;
	
	public Student() {}
	
	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		LastName = lastName;
		this.email = email;
	}
	
	// add dependency if courses create for this student
	public void addCourse(Course course) {
		
		if(courses == null)
			courses = new ArrayList<>();
		
		courses.add(course);
		
		course.setStudent(this);
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
}
