package com.cg.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.demo.bean.Student;
import com.cg.demo.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService; 
	@RequestMapping("/student")
	 public String addPage(Model m) {
		m.addAttribute("students",studentService.getAllStudent());
		 return "AddStudent";
	 }
	@RequestMapping("/hello")
	public String addStudent(Student student) {
		studentService.addStudent(student);
		return "redirect:student";
	}
	@RequestMapping("/removeStudent")
	public String delStudent(@RequestParam String sid) {
		studentService.delStudent(Integer.parseInt(sid));
		return "redirect:student";
	}
}
