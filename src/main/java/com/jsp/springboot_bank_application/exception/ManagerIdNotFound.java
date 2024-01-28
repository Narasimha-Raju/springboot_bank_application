package com.jsp.springboot_bank_application.exception;

public class ManagerIdNotFound extends RuntimeException{
	private String message="MANAGER ID NOT FOUND IN THE DATABASE";

	public String getMessage() {
		return message;
	}
	
}
