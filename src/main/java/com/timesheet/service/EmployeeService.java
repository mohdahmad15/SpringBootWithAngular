package com.timesheet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.timesheet.entity.Employee;
import com.timesheet.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository emplRepo;
	
	//Create method to performe operation 
	
	public Employee postEntry(Employee employee) {
		
		System.out.println(employee);
		
		return emplRepo.save(employee);	
	}
	
	public List<Employee> getAllEntries(){
		
		return emplRepo.findAll();
	}
	
	public void deleteEntries(Long id) {
		
		emplRepo.deleteById(id);
	}
	
	public Employee getDetailsById(Long id) {
		
		return emplRepo.findById(id).orElse(null);
	}
	
	public Employee updateDetails(Long id,Employee employee) {
		Optional<Employee> optionlalEmpl=emplRepo.findById(id);
		if(optionlalEmpl.isPresent()) {
			Employee existingEmp=optionlalEmpl.get();
			existingEmp.setClientId(employee.getClientId());
			existingEmp.setProjectName(employee.getProjectName());
			existingEmp.setAddEntry(employee.getAddEntry());
			existingEmp.setTimeSpend(employee.getTimeSpend());
			existingEmp.setTag(employee.getTag());
			existingEmp.setRemarks(employee.getRemarks());
			return emplRepo.save(existingEmp);
		}
		
		return null;
	}
}
