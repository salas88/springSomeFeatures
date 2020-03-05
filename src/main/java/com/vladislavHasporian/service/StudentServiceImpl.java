package com.vladislavHasporian.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vladislavHasporian.entity.Student;
import com.vladislavHasporian.repository.StudentRepo;

@Service
public class StudentServiceImpl implements IStudentService{
	
	private StudentRepo studentRepo;
	
	@Autowired
	public StudentServiceImpl(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	public List<Student> findAll(){
		return studentRepo.findAll();
	}

	@Override
	public void save(Student theStudent) {
		studentRepo.save(theStudent);
		
	}

	@Override
	public void delete(int theId) {
		studentRepo.deleteById(theId);
		
	}

	@Override
	public Optional<Student> findById(int theId) {
		
		return studentRepo.findById(theId);
	}



}
