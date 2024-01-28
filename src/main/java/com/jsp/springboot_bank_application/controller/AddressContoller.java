package com.jsp.springboot_bank_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_bank_application.dto.Address;
import com.jsp.springboot_bank_application.service.AddressService;
import com.jsp.springboot_bank_application.util.ResponseStructure;

@RestController
public class AddressContoller {

	@Autowired
	AddressService addressService;
	
	//saving Address
	@PostMapping("saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	//Deleting Address
	@DeleteMapping("deleteAddress")
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@RequestParam int addressId) {
		return addressService.deleteAddressById(addressId);
	}
	
	//Fetching Address
	@GetMapping("fetchAddress")
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(@RequestParam int addressId) {
		return addressService.fetchAddressById(addressId);
	}
	
	//Updating Address
	@PutMapping("updateAddress")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int addressId,@RequestBody Address address) {
		return addressService.updateAddress(addressId, address);
	}
}
