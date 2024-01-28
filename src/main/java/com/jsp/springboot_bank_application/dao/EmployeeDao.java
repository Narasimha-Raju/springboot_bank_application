package com.jsp.springboot_bank_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_bank_application.dto.Employee;
import com.jsp.springboot_bank_application.repo.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepository employeeRepository;
	
	//Saving Employee
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	//Deleting Employee
	public Employee deleteEmployeeById(int employeeId) {
		Employee employee=employeeRepository.findById(employeeId).get();
		employeeRepository.deleteById(employeeId);
		return employee;
	}
	
	//Fetching Employee
	public Employee fetchEmployeeById(int employeeId) {
		Optional<Employee> optional=employeeRepository.findById(employeeId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	//Updating Employee
	public Employee updateEmployee(int employeeId,Employee employee) {
		employee.setEmployeeId(employeeId);
		return employeeRepository.save(employee);
	}
}

