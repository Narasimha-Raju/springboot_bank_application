package com.jsp.springboot_bank_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_bank_application.dao.AddressDao;
import com.jsp.springboot_bank_application.dto.Address;
import com.jsp.springboot_bank_application.exception.AddressIdNotFound;
import com.jsp.springboot_bank_application.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;
	
	//saving Address
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Address details Inserted into DataBase");
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	}
	
	//Deleting Address
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int addressId) {
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		Address address=addressDao.fetchAddressById(addressId);
		if (address!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Deleted from DataBase");
			responseStructure.setData(addressDao.deleteAddressById(addressId));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AddressIdNotFound();
		}
	}
	
	//Fetching Address
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int addressId) {
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		Address address=addressDao.fetchAddressById(addressId);
		if (address!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Fecthed from DataBase");
			responseStructure.setData(addressDao.fetchAddressById(addressId));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new AddressIdNotFound();
		}
	}
	
	//Updating Address 
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int addressId,Address address) {
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		Address address2=addressDao.fetchAddressById(addressId);
		if (address2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Address Updated in DataBase");
			responseStructure.setData(addressDao.updateAddress(addressId, address));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AddressIdNotFound();
		}
	}
}
