package com.timesheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeTimesheetApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeTimesheetApplication.class, args);
		
		System.err.println("Application is running");
	}

}
