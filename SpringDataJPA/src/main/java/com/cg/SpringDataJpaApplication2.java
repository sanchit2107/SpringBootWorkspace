package com.cg;


import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.model.Survey;
import com.cg.service.SurveyService;

public class SpringDataJpaApplication2 {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringDataJpaApplication.class, args);
		
		SurveyService service = ctx.getBean(SurveyService.class);
//		SurveyService service = ctx.getBean("surveyService", SurveyService.class);
		Survey s1 = new Survey();
		Survey s2 = new Survey();
		Survey s3 = new Survey();
		
		s1.setName("Land Survey");
		s1.setCost(45000);
		
		s2.setName("Population Survey");
		s2.setCost(75000);
		
		s3.setName("Literacy Survey");
		s3.setCost(35000);
		
		service.addSurvey(s1);
		service.addSurvey(s2);
		service.addSurvey(s3);
		
		System.out.println("Find Id");
		service.findSurvey(3);
		
		System.out.println("Remove ID");
		service.removeSurvey(2);
		
		System.out.println("All Survey records!!");
		service.showAllSurvey();
		
		ctx.stop();
	}

}
