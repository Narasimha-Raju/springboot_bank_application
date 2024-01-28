package com.jsp.springboot_bank_application.exception;

public class CustomerIdNotFound extends RuntimeException{
	private String message="CUSTOMER ID NOT FOUND IN THE DATABASE";

	public String getMessage() {
		return message;
	}
}
