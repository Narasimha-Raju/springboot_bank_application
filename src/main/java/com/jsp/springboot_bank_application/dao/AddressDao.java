package com.jsp.springboot_bank_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_bank_application.dto.Address;
import com.jsp.springboot_bank_application.repo.AddressRepository;

@Repository
public class AddressDao {

	@Autowired
	AddressRepository addressRepository;
	
	//saving Address
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}
	
	//Deleting Address
	public Address deleteAddressById(int addressId) {
		Address address=fetchAddressById(addressId);
		addressRepository.deleteById(addressId);
		return address;
	}
	
	//Fetching Address
	public Address fetchAddressById(int addressId) {
		Optional<Address> optional=addressRepository.findById(addressId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	//Updating Address
	public Address updateAddress(int addressId,Address address) {
		address.setAddressId(addressId);
		return addressRepository.save(address);
	}
}
