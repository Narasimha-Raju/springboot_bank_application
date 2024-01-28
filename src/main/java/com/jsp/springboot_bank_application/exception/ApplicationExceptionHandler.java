package com.jsp.springboot_bank_application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springboot_bank_application.dto.Account;
import com.jsp.springboot_bank_application.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(AccountIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> accountIdNotFound(AccountIdNotFound accountIdNotFound) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(accountIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> addressIdNotFound(AddressIdNotFound addressIdNotFound) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(addressIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ATMIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> atmIdNotFound(ATMIdNotFound atmIdNotFound) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(atmIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BankIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> bankIdNotFound(BankIdNotFound bankIdNotFound) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(bankIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> branchIdNotFound(BranchIdNotFound branchIdNotFound) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(branchIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> customerIdNotFound(CustomerIdNotFound customerIdNotFound) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(customerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> employeeIdNotFound(EmployeeIdNotFound employeeIdNotFound) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(employeeIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ManagerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> managerIdNotFound(ManagerIdNotFound managerIdNotFound) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(managerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);	}
}
