package com.jsp.springboot_bank_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_bank_application.dto.Account;
import com.jsp.springboot_bank_application.dto.Customer;
import com.jsp.springboot_bank_application.service.CustomerService;
import com.jsp.springboot_bank_application.util.ResponseStructure;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	// Saving Customer
	@PostMapping("saveCustomer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	// Deleting Customer
	@DeleteMapping("deleteCustomer")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(@RequestParam int customerId) {
		return customerService.deleteCustomerById(customerId);
	}

	// Fetching Customer
	@GetMapping("fetchCustomer")
	public ResponseEntity<ResponseStructure<Customer>> fetchCustomerById(int customerId) {
		return customerService.fetchCustomerById(customerId);
	}

	// Update Customer
	@PutMapping("updateCustomer")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestParam int customerId,
			@RequestBody Customer customer) {
		return customerService.updateCustomer(customerId, customer);
	}

	// addNewAccountToExistingCustomer
	@PutMapping("addNewAccountToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addNewAccountToExistingCustomer(@RequestParam int existingCustomerId,@RequestBody List<Account> newAccount) {
		return customerService.addNewAccountToExistingCustomer(existingCustomerId, newAccount);
	}
}
