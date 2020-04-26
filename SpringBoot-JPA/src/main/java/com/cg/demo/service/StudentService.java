package com.cg.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.demo.bean.Student;
import com.cg.demo.dao.StudentDao;

@Service
public class StudentService {
	@Autowired
	StudentDao studentDao; 
	public void addStudent(Student student) {
		studentDao.save(student);
	}
	public Iterable<Student> getAllStudent() {
		return studentDao.findAll();
	}
	public Student findStudent(int sid) {
		Optional<Student> o=studentDao.findById(sid);
		return o.get();
	}
	public void delStudent(int sid) {
		studentDao.delete(findStudent(sid));
	}
}
