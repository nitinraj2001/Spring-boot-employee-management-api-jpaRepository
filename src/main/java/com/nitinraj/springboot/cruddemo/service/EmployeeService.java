package com.nitinraj.springboot.cruddemo.service;

import java.util.List;

import com.nitinraj.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
public List<Employee> getAllEmployees();
	
	public Employee getempById(int theID);
	
	public void saveEmployee(Employee employee);
	
	public void deleteById(int theID);

}
