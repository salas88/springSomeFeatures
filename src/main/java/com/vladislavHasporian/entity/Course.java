package com.vladislavHasporian.entity;

import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String article;
	private String review;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE,
				     	 CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="student_id")
	private Student student;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="course_id")
	private List<Review> reviews;
	
	@ManyToMany(cascade= {CascadeType.DETACH, CascadeType.MERGE,
	     	 	CascadeType.PERSIST, CascadeType.REFRESH},
			 	fetch=FetchType.LAZY)
	@JoinTable(name="course_instrictor", joinColumns=@JoinColumn(name="course_id"),
							inverseJoinColumns=@JoinColumn(name="instructor_id"))
	private List<Instructor> instructors;
	
	public void addReview(Review review) {
		if(reviews == null) {
			reviews = new ArrayList<>();
		}
		reviews.add(review);
	}
	
	public void addInstructor(Instructor theInstructor) {
		if(instructors == null) {
			instructors = new ArrayList<>();
		}else
			instructors.add(theInstructor);
	}
	
	
	
	public Course() {}
	
	public Course(String article, String review) {
		this.article = article;
		this.review = review;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}
	
	
}
