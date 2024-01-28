package com.jsp.springboot_bank_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_bank_application.dto.Employee;
import com.jsp.springboot_bank_application.service.EmployeeService;
import com.jsp.springboot_bank_application.util.ResponseStructure;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	//Saving Employee
	@PostMapping("saveEmployee")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	//Deleting Employee
	@DeleteMapping("deleteEmployee")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(@RequestParam int employeeId) {
		return employeeService.deleteEmployeeById(employeeId);
	}
	
	//Fetching Employee
	@GetMapping("fetchEmployee")
	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(@RequestParam int employeeId) {
		return employeeService.fetchEmployeeById(employeeId);
	}
	
	//Updating Employee
	@PutMapping("updateEmployee")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestParam int employeeId,@RequestBody Employee employee) {
		return employeeService.updateEmployee(employeeId, employee);
	}
}
