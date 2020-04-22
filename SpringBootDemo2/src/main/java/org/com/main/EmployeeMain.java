package org.com.main;

import org.com.bean.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@EnableAutoConfiguration
@ComponentScan("org.com")
@PropertySource("classpath:/empl.properties")
public class EmployeeMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(EmployeeMain.class, args);
		Employee e = (Employee)ctx.getBean("emp");
		e.printEmployee();
	}

}
