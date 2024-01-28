package com.jsp.springboot_bank_application.exception;

public class BankIdNotFound extends RuntimeException{

	private String message="BANK ID NOT FOUND IN THE DATABASE";

	public String getMessage() {
		return message;
	}
}