package com.cg.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Survey;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Integer> {

}
