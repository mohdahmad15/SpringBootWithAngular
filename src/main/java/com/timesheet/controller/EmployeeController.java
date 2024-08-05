package com.timesheet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.timesheet.entity.Employee;
import com.timesheet.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService empSer;
	
	//Create entry by this method
	@PostMapping("/employee")
	public Employee postEntry(@RequestBody Employee employee) {
		
		return empSer.postEntry(employee);
	}
	
	//Fetch All entries 
	@GetMapping("/employee")
	public List<Employee> getAllEntries(){
		
		return empSer.getAllEntries();
	}
	
	//Delete entries by Id
	@DeleteMapping("/employee/{id}")
	public void deleteEntries(@PathVariable Long id) {
		empSer.deleteEntries(id);
	}
	
	//get details by Id 
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getDetailsById(@PathVariable Long id) {
		
		Employee employee=empSer.getDetailsById(id);
		if(employee==null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(employee);
	}
	
	//update records and save data in database
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEntries(@PathVariable Long id,@RequestBody Employee employee){
		
		Employee updatedRecords= empSer.updateDetails(id, employee);
		if(updatedRecords==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.ok(updatedRecords);
	}
}
