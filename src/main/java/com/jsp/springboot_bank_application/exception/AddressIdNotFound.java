package com.jsp.springboot_bank_application.exception;

public class AddressIdNotFound extends RuntimeException{
	private String message="ACCOUNT ID NOT FOUND IN THE DATABASE";

	public String getMessage() {
		return message;
	}
	
}
