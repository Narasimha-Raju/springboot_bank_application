package com.jsp.springboot_bank_application.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	private long accountNumber;
	private String accountType;
	private double accountMinimumBalance;
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAccountMinimumBalance() {
		return accountMinimumBalance;
	}
	public void setAccountMinimumBalance(double accountMinimumBalance) {
		this.accountMinimumBalance = accountMinimumBalance;
	}
	
	
}
