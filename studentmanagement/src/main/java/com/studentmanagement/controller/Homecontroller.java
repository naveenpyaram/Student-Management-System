package com.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentmanagement.entity.Student;
import com.studentmanagement.service.StudentService;

@Controller
public class Homecontroller {
	@Autowired
	private StudentService service;
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", service.getAllAtudents());
		return "students";
	}
	@GetMapping("students/new")
	public String createstudent(Model model) {
		Student std = new Student();
		model.addAttribute("students", std);
		return "create-student";
	}
	@PostMapping("/students")
	public String savestudent(@ModelAttribute("students") Student std) {
		service.savestudent(std);
		return "redirect:/students";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		model.addAttribute("students", service.getById(id));
		return "update-student2";
	}
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id,@ModelAttribute("students") Student std) {
		 Student existingstudent = service.getById(id);
		 existingstudent.setFirstname(std.getFirstname());
		 existingstudent.setLastname(std.getLastname());
		 existingstudent.setEmail(std.getEmail());
		 service.savestudent(existingstudent);
		 return "redirect:/students";
	}
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		service.deletebyid(id);
		return "redirect:/students";
	}

}
