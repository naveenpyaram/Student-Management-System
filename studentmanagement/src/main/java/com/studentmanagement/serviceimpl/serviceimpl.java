package com.studentmanagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.entity.Student;
import com.studentmanagement.repository.StudentRepository;
import com.studentmanagement.service.StudentService;

@Service
public class serviceimpl implements StudentService{
	
	@Autowired
	private StudentRepository studentrepository;

	@Override
	public List<Student> getAllAtudents() {
		List<Student> list = studentrepository.findAll();
		return list;
	}

	@Override
	public Student savestudent(Student std) {
	
		return studentrepository.save(std);
	}

	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		return studentrepository.findById(id).get();
	}

	@Override
	public void deletebyid(int id) {
		// TODO Auto-generated method stub
		studentrepository.deleteById(id);
		
	}

	
  
	

}
