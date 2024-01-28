package com.jsp.springboot_bank_application.exception;

import org.springframework.http.HttpStatus;

import com.jsp.springboot_bank_application.util.ResponseStructure;

public class AccountIdNotFound extends RuntimeException{
	
	private String message="ACCOUNT ID NOT FOUND IN THE DATABASE";

	public String getMessage() {
		return message;
	}
	
}
