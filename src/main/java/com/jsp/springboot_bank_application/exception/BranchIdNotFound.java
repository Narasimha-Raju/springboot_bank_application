package com.jsp.springboot_bank_application.exception;

public class BranchIdNotFound extends RuntimeException{

	private String message="BRANCH ID NOT FOUND IN THE DATABASE";

	public String getMessage() {
		return message;
	}
	
}
