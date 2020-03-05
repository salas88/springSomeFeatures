package com.vladislavHasporian.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToMany(cascade= {CascadeType.DETACH, CascadeType.MERGE,
				     	 CascadeType.PERSIST, CascadeType.REFRESH},
			    fetch=FetchType.LAZY)
	@JoinTable(name="course_instrictor", joinColumns=@JoinColumn(name="instructor_id"),
										inverseJoinColumns=@JoinColumn(name="course_id"))
	private List<Course> course;
	
	public Instructor() {}

	public Instructor(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}
	
}
