package com.jsp.springboot_bank_application.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	private String addressPlotNumber;
	private String addressLandMark;
	private String addressStreet;
	private String addressMandal;
	private String addressDistrict;
	private String addressState;
	private int addressPincode;
	private String addressCountry;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressPlotNumber() {
		return addressPlotNumber;
	}
	public void setAddressPlotNumber(String addressPlotNumber) {
		this.addressPlotNumber = addressPlotNumber;
	}
	public String getAddressLandMark() {
		return addressLandMark;
	}
	public void setAddressLandMark(String addressLandMark) {
		this.addressLandMark = addressLandMark;
	}
	public String getAddressStreet() {
		return addressStreet;
	}
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}
	public String getAddressMandal() {
		return addressMandal;
	}
	public void setAddressMandal(String addressMandal) {
		this.addressMandal = addressMandal;
	}
	public String getAddressDistrict() {
		return addressDistrict;
	}
	public void setAddressDistrict(String addressDistrict) {
		this.addressDistrict = addressDistrict;
	}
	public String getAddressState() {
		return addressState;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	public int getAddressPincode() {
		return addressPincode;
	}
	public void setAddressPincode(int addressPincode) {
		this.addressPincode = addressPincode;
	}
	public String getAddressCountry() {
		return addressCountry;
	}
	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}
	
}
