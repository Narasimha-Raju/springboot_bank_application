package com.jsp.springboot_bank_application.exception;

public class ATMIdNotFound extends RuntimeException{

	private String message="ATM ID NOT FOUND IN THE DATABASE";

	public String getMessage() {
		return message;
	}
	
}
