package com.vladislavHasporian.service;

import java.util.List;
import java.util.Optional;

import com.vladislavHasporian.entity.Student;

public interface IStudentService {
		
	List<Student> findAll();
	void save(Student theStudent);
	void delete(int theId);
	Optional<Student> findById(int theId);
}
