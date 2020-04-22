package org.com;

import org.com.model.Employee;
import org.com.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDataJpaPaginationApplication {

	public static void main(String[] args) {
		 ConfigurableApplicationContext bean =  SpringApplication.run(SpringDataJpaPaginationApplication.class, args);
		 EmployeeService service = bean.getBean(EmployeeService.class);
		 
		 String name[] = {"Ram Kumar", "Suresh Kumar", "Neeraj Kumar", "Anil Kumar", "Deeraj Kumar"};
		 float salary[] = {20000, 18000, 23000, 19000, 25000};
		 
		 Employee emp[] = new Employee[5];
		 
		 for(int i=0; i<emp.length; i++) {
			 emp[i] = new Employee();
			 emp[i].setName(name[i]);
			 emp[i].setSalary(salary[i]);
			 service.addEmployee(emp[i]);
		 }
		 
		 System.out.println("All Employees!!");
		 
		 service.showAllEmployee();
	}

}
