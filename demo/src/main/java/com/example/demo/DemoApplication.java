package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(DemoApplication.class, args);
		Employee employee1 = context.getBean(Employee.class);
		employee1.setId(101);
		employee1.setName("Emp 1");
		employee1.setGender("Male");
		employee1.setPhoneNumber("9876543213");

		EmployeeRepo repo=context.getBean(EmployeeRepo.class);
		repo.save(employee1);

		System.out.println(repo.findAll());
	}

}
