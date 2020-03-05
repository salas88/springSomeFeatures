package com.vladislavHasporian.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vladislavHasporian.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
