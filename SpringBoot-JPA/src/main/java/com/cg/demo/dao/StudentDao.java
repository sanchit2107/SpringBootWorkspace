package com.cg.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.cg.demo.bean.Student;

public interface StudentDao extends CrudRepository<Student, Integer> {
	
}
