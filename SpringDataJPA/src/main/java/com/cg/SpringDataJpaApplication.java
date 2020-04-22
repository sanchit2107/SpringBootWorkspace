package com.cg;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.dao.SurveyRepository;
import com.cg.model.Survey;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(SpringDataJpaApplication.class, args);
		
		SurveyRepository dao = ctx.getBean(SurveyRepository.class);
		
		Survey s1 = new Survey();
		Survey s2 = new Survey();
		Survey s3 = new Survey();
		
		s1.setName("Land Survey");
		s1.setCost(45000);
		
		s2.setName("Population Survey");
		s2.setCost(75000);
		
		s3.setName("Literacy Survey");
		s3.setCost(35000);
		
		dao.save(s1);
		dao.save(s2);
		dao.save(s3);
		
		System.out.println("Find Id");
		Optional<Survey> findByID = dao.findById(1);
		if(findByID.isPresent()) {
			System.out.println("Found " + findByID.get());
		}
		else
			System.out.println("Not Found!!");
		
		System.out.println("All Survey records!!");
		Iterable<Survey> findAll = dao.findAll();
		for(Survey s: findAll) {
			
			System.out.println(s);
		}
		
		ctx.stop();
	}

}
