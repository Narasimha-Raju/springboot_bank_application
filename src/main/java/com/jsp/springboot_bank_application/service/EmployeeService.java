package com.jsp.springboot_bank_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_bank_application.dao.EmployeeDao;
import com.jsp.springboot_bank_application.dto.Employee;
import com.jsp.springboot_bank_application.exception.EmployeeIdNotFound;
import com.jsp.springboot_bank_application.util.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	//Saving Employee
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		ResponseStructure<Employee> responseStructure=new ResponseStructure<Employee>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Employee details Inserted into DataBase");
		responseStructure.setData(employeeDao.saveEmployee(employee));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.CREATED);
	}
	
	//Deleting Employee
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(int employeeId) {
		ResponseStructure<Employee> responseStructure=new ResponseStructure<Employee>();
		Employee employee=employeeDao.fetchEmployeeById(employeeId);
		if (employee!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Deleted from DataBase");
			responseStructure.setData(employeeDao.deleteEmployeeById(employeeId));
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
		} else {
			throw new EmployeeIdNotFound();
		}
	}
	
	//Fetching Employee
	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(int employeeId) {
		ResponseStructure<Employee> responseStructure=new ResponseStructure<Employee>();
		Employee employee=employeeDao.fetchEmployeeById(employeeId);
		if (employee!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Fetched from DataBase");
			responseStructure.setData(employeeDao.fetchEmployeeById(employeeId));
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new EmployeeIdNotFound();
		}
	}
	
	//Updating Employee
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(int employeeId,Employee employee) {
		ResponseStructure<Employee> responseStructure=new ResponseStructure<Employee>();
		Employee employee2=employeeDao.fetchEmployeeById(employeeId);
		if (employee2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Employee Details Updated in DataBase");
			responseStructure.setData(employeeDao.updateEmployee(employeeId, employee));
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
		} else {
			throw new EmployeeIdNotFound();
		}
	}
}
