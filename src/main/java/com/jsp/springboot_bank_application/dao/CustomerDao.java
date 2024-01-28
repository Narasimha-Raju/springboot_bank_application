package com.jsp.springboot_bank_application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_bank_application.dto.Account;
import com.jsp.springboot_bank_application.dto.Customer;
import com.jsp.springboot_bank_application.repo.CustomerRepository;

@Repository
public class CustomerDao {

	@Autowired
	CustomerRepository customerRepository;
	
	//Saving Customer
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	//Deleting Customer
	public Customer deleteCustomerById(int customerId) {
		Customer customer=customerRepository.findById(customerId).get();
		customerRepository.deleteById(customerId);
		return customer;
	}
	
	//Fetching Customer
	public Customer fetchCustomerById(int customerId) {
		Optional<Customer> optional=customerRepository.findById(customerId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	//Update Customer
	public Customer updateCustomer(int custometId,Customer customer) {
		customer.setCustomerId(custometId);
		return customerRepository.save(customer);
	}
	
	//addNewAccountToExistingCustomer
	public Customer addNewAccountToExistingCustomer(int existingCustomerId, List<Account> newAccount) {
		Customer customer=fetchCustomerById(existingCustomerId);
		List<Account> accounts=customer.getAccount();
		accounts.addAll(newAccount);
		customer.setAccount(accounts);
		return saveCustomer(customer);
	}
}
