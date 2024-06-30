package com.example.FirstSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner initialCreate(EmploeeService emploeeService){
//		return (args) ->{
//
//			Address address1 = new Address("Line 1","Line 2","ZipeCode1","State1","Country1");
//			Project project1 = new Project("Name1","Client Name1");
//			Spouse spouse1 = new Spouse("Name1","Mobile1",30);
//
//			Employee employee = new Employee("Employee1","City1");
//			employee.addProject(project1);
//			employee.addAddress(address1);
//			employee.setSpouse(spouse1);
//
//			emploeeService.createEmployee(employee);
//
//			System.out.println("Getting an employee");
//			Employee employee1 = emploeeService.getAnEmployee(1);
//		};
//	}
}
