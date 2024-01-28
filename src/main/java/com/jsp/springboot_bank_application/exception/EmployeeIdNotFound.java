package com.jsp.springboot_bank_application.exception;

public class EmployeeIdNotFound extends RuntimeException{
	private String message="EMPLOYEE ID NOT FOUND IN THE DATABASE";

	public String getMessage() {
		return message;
	}
	
}
