package org.com.controller;

import java.util.ArrayList;
import java.util.List;

import org.com.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	static ArrayList<Employee > empList;
	
	static {
		empList = new ArrayList<>();
		Employee employee[] = new Employee[4];
		employee[0] = new Employee(1001, "Sanchit", 52000, "Delhi");
		employee[1] = new Employee(1002, "Piyush", 65000, "Kerala");
		employee[2] = new Employee(1003, "Riya", 32000, "Gurgaon");
		employee[3] = new Employee(1004, "Sadia", 20000, "Pune");
		
		empList.add(employee[0]);
		empList.add(employee[1]);
		empList.add(employee[2]);
		empList.add(employee[3]);
		
	}
	
	
	@GetMapping("/displayAllEmployee")
	public List<Employee> showAll() {
		
		return empList;
	}
	
	@GetMapping("/searchEmployee/{id}")
	public Employee findEmp(@PathVariable("id") int id) {
		
		Employee e=null;
		for(Employee employee: empList) {
			if(id == employee.getId()) {
				e = employee;
				break;
			}
		}
		return e;
	}
	
	
	@RequestMapping("/meanSalary")
	public String meanSalary() {
		
		float f = 0;
		for(Employee e: empList) {
			
			f = f + e.getSalary();
		}
		
		int size = empList.size();
		float result = f/size;
		
		return "Mean Salary = " + result;
	}
	
	@RequestMapping("/totalSalary")
	public String totalSalary() {
		
		float f = 0;
		for(Employee e: empList) {
			
			f = f + e.getSalary();
		}	
		return "Total Salary = " + f;
	}
	
	
	@RequestMapping("/maxSalary")
	public String maximumSalary() {
		
		float f = 0;
		for(Employee e: empList) {
			
			if(e.getSalary() > f)
				f = e.getSalary();
		}	
		
		return "Maximum Salary = " + f;
	}
	
	
	
	@RequestMapping("/minSalary")
	public String minimumSalary() {
		
		float f = 10000000;
		for(Employee e: empList) {
			
			if(e.getSalary() < f)
				f = e.getSalary();
		}	
		return "Minimum Salary = " + f;
	}
	
	@RequestMapping("/hello")
	public String hello() {
		
		return "<h1>hello world</h1>";
	}
	
	@RequestMapping("/employee")
	public Employee getEmp() {
		
		Employee e = new Employee();
		e.setId(1001);
		e.setName("Suresh");
		e.setSalary(158000);
		e.setLocation("Bangalore");
		return e;
	}
}
