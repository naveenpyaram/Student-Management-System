package com.studentmanagement.service;

import java.util.List;

import com.studentmanagement.entity.Student;

public interface StudentService {
	public List<Student> getAllAtudents();
	public Student savestudent(Student std);
	public Student getById(int id);
	public void deletebyid(int id);
	
}
