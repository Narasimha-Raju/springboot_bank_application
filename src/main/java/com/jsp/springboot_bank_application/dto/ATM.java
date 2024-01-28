package com.jsp.springboot_bank_application.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ATM {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int atmId;
	private String atmName;
	private String atmtype;
	private int atmSecurities;
	private double atmCapacity;
	public int getAtmId() {
		return atmId;
	}
	public void setAtmId(int atmId) {
		this.atmId = atmId;
	}
	public String getAtmName() {
		return atmName;
	}
	public void setAtmName(String atmName) {
		this.atmName = atmName;
	}
	public String getAtmtype() {
		return atmtype;
	}
	public void setAtmtype(String atmtype) {
		this.atmtype = atmtype;
	}
	public int getAtmSecurities() {
		return atmSecurities;
	}
	public void setAtmSecurities(int atmSecurities) {
		this.atmSecurities = atmSecurities;
	}
	public double getAtmCapacity() {
		return atmCapacity;
	}
	public void setAtmCapacity(double atmCapacity) {
		this.atmCapacity = atmCapacity;
	}
	
}
