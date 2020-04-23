package org.com;

import org.com.model.Employee;
import org.com.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
//@ActiveProfiles("development")
public class SpringProfileCreationMicroServicesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringProfileCreationMicroServicesApplication.class, args);
		EmployeeService service = ctx.getBean(EmployeeService.class);
		
		String name[] = {"Ram Kumar", "Suresh Kumar", "Neeraj Kumar", "Aman Kumar", "Deeraj Kumar",};
		 float salary[] = {20000, 18000, 23000, 19000, 25000};
		 
		 Employee emp[] = new Employee[20];
		 
		 int x=0;
		 for(int i=0; i<emp.length; i++) {
			 emp[i] = new Employee();
			 emp[i].setName(name[x]);
			 emp[i].setSalary(salary[x]);
			 service.addEmployee(emp[i]);
			 x++;
			 if(x == 5)
				 x = 0;
		 }
		 
		 System.out.println("All Employees!!");
		 service.showAllEmployee();
		 
	}

}
