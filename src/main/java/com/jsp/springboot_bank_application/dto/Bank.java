package com.jsp.springboot_bank_application.dto;




import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankId;
	private String bankName;
	private String bankFounder;
	private String bankCEO;
	private double bankNetworth;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Branch> branchs;
	
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankFounder() {
		return bankFounder;
	}
	public void setBankFounder(String bankFounder) {
		this.bankFounder = bankFounder;
	}
	public String getBankCEO() {
		return bankCEO;
	}
	public void setBankCEO(String bankCEO) {
		this.bankCEO = bankCEO;
	}
	public double getBankNetworth() {
		return bankNetworth;
	}
	public void setBankNetworth(double bankNetworth) {
		this.bankNetworth = bankNetworth;
	}
	public List<Branch> getBranchs() {
		return branchs;
	}
	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}
	
}
