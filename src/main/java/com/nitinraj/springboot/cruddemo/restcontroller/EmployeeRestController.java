package com.nitinraj.springboot.cruddemo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.nitinraj.springboot.cruddemo.service.EmployeeService;

import com.nitinraj.springboot.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService theEmployeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		theEmployeeService=employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		
		return theEmployeeService.getAllEmployees();
		
	}
	
	@GetMapping("/employees/{employeeID}")
	public Employee getEmployee(@PathVariable int employeeID) {
		
		Employee theEmployee=theEmployeeService.getempById(employeeID);
		
		if(theEmployee==null) {
			throw new RuntimeException("employee id is not found " +employeeID);
		}
		
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		
		theEmployeeService.saveEmployee(theEmployee);
		
		return "Employee is saved successfully";
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		theEmployeeService.saveEmployee(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeID}")
	public String deleteEmployee(@PathVariable int employeeID) {
		Employee theEmployee=theEmployeeService.getempById(employeeID);
		if(theEmployee==null) {
			throw new RuntimeException("employee id is not found "+employeeID);
		}
		theEmployeeService.deleteById(employeeID);
		
		return "employee is successfully deleted"+employeeID;
	}

}
