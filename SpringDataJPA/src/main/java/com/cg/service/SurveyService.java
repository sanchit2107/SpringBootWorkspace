package com.cg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.SurveyRepository;
import com.cg.model.Survey;

@Service
public class SurveyService {

	@Autowired
	SurveyRepository dao;
	
	public void addSurvey(Survey s) {
		
		Optional<Survey> findById = dao.findById(s.getId());
		if(findById.isPresent())
			System.out.println("Survey Already exists!!");
		else {
			dao.save(s);
			System.out.println("Survey Added!!");
		}
	}
	
	public void showAllSurvey() {
		
		System.out.println("All records---");
		dao.findAll().forEach(System.out::println);
	}
	
	public void findSurvey(int id) {
		
		Optional<Survey> findById = dao.findById(id);
		if(findById.isPresent())
			System.out.println("Found Survey -- " + findById.get());
		else
			System.out.println("Survey Not Found for id = "+ id );
	}
	
	public void removeSurvey(int id) {
		
		if(dao.findById(id).isPresent()) {
			dao.deleteById(id);
			System.out.println("Record Deleted!!!");
		}
		else {
			System.out.println("Record not found!!");
		}
	}
}
