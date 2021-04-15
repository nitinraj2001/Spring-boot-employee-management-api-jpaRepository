package com.nitinraj.springboot.cruddemo.service;

import java.util.List;

import java.util.Optional;


import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.nitinraj.springboot.cruddemo.dao.EmployeeRepository;

import com.nitinraj.springboot.cruddemo.entity.Employee;

@Transactional
@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	
	private EmployeeRepository theEmployeeRepository;
	
	public EmployeeServiceImplementation(EmployeeRepository EmployeeRepository) {
		theEmployeeRepository=EmployeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return theEmployeeRepository.findAll();
	}

	@Override
	public Employee getempById(int theID) {
		
		Optional<Employee> result = theEmployeeRepository.findById(theID);
		
		Employee theEmployee=null;
		
		if(result.isPresent()) {
			theEmployee=result.get();
		}
		else {
			throw new RuntimeException("Employee id is not found");
		}
		return theEmployee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		
		theEmployeeRepository.save(employee);
		
	}

	@Override
	public void deleteById(int theID) {
		
		theEmployeeRepository.deleteById(theID);
		
		
	}

}
