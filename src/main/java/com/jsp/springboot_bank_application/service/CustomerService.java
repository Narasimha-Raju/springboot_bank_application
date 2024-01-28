package com.jsp.springboot_bank_application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_bank_application.dao.CustomerDao;
import com.jsp.springboot_bank_application.dto.Account;
import com.jsp.springboot_bank_application.dto.Customer;
import com.jsp.springboot_bank_application.exception.CustomerIdNotFound;
import com.jsp.springboot_bank_application.util.ResponseStructure;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	//Saving Customer
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Customer details Inserted into DataBase");
		responseStructure.setData(customerDao.saveCustomer(customer));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
	}
	
	//Deleting Customer
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(int customerId) {
		ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
		Customer customer=customerDao.fetchCustomerById(customerId);
		if (customer!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Deleted from DataBase");
			responseStructure.setData(customerDao.deleteCustomerById(customerId));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		} else {
			throw new CustomerIdNotFound();
		}
	}
	
	//Fetching Customer
	public ResponseEntity<ResponseStructure<Customer>> fetchCustomerById(int customerId) {
		ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
		Customer customer=customerDao.fetchCustomerById(customerId);
		if (customer!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Fetched from DataBase");
			responseStructure.setData(customerDao.deleteCustomerById(customerId));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new CustomerIdNotFound();
		}
	}
	
	//Update Customer
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(int custometId,Customer customer) {
		ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
		Customer customer2=customerDao.fetchCustomerById(custometId);
		if (customer2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Customer Details Updated in DataBase");
			responseStructure.setData(customerDao.updateCustomer(custometId, customer));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		} else {
			throw new CustomerIdNotFound();
		}
	}
	
	//addNewAccountToExistingCustomer
	public ResponseEntity<ResponseStructure<Customer>> addNewAccountToExistingCustomer(int existingCustomerId, List<Account> newAccount) {
		ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Account added to Customer in DataBase");
		responseStructure.setData(customerDao.addNewAccountToExistingCustomer(existingCustomerId, newAccount));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
	}
}
