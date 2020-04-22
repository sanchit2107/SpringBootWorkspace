package org.com.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("emp")
public class Employee {
	
	@Value("${id}")
	private int id;
	@Value("${name}")
	private String name;
	@Value("${email}")
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void printEmployee() {
		
		System.out.println("Employee ID = "+ id);
		System.out.println("Employee Name = "+ name);
		System.out.println("Employee Email = "+ email);
	}
}
