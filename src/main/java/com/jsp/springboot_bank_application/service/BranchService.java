package com.jsp.springboot_bank_application.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_bank_application.dao.BranchDao;
import com.jsp.springboot_bank_application.dto.ATM;
import com.jsp.springboot_bank_application.dto.Address;
import com.jsp.springboot_bank_application.dto.Branch;
import com.jsp.springboot_bank_application.dto.Customer;
import com.jsp.springboot_bank_application.dto.Employee;
import com.jsp.springboot_bank_application.dto.Manager;
import com.jsp.springboot_bank_application.exception.BranchIdNotFound;
import com.jsp.springboot_bank_application.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao; 

	// Saving Branch
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Inserted into DataBase");
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}

	// Deleting Branch
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int branchId) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		Branch branch=branchDao.fetchBranchById(branchId);
		if (branch!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Deleted from DataBase");
			responseStructure.setData(branchDao.deleteBranchById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	// Fetching Branch
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int branchId) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		Branch branch=branchDao.fetchBranchById(branchId);
		if (branch!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Fetched from DataBase");
			responseStructure.setData(branchDao.fetchBranchById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new BranchIdNotFound();
		}
	}

	// Updating Branch
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int branchId, Branch branch) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		Branch branch2=branchDao.fetchBranchById(branchId);
		if (branch2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Branch Updated in DataBase");
			responseStructure.setData(branchDao.updateBranch(branchId, branch));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
		
	}

	// addExistingAddressToExistingBranch
	public Branch addExistingAddressToExistingBranch(int existingBranchId, int existingAddressId) {
		return branchDao.addExistingAddressToExistingBranch(existingBranchId, existingAddressId);
	}

	// addNewAddressToExistingBranch
	public Branch addNewAddressToExistingBranch(int existingBranchId, Address newAddress) {
		return branchDao.addNewAddressToExistingBranch(existingBranchId, newAddress);
	}

	// addNewManagerToExistingBranch
	public Branch addNewManagerToExistingBranch(int existingBranchId, Manager manager) {
		return branchDao.addNewManagerToExistingBranch(existingBranchId, manager);
	}

	// addNewAtmsToExistingBranch
	public Branch addNewAtmsToExistingBranch(int existingBranchId, List<ATM> atms) {
		return branchDao.addNewAtmsToExistingBranch(existingBranchId, atms);
	}

	// addNewCustomersToExistingBranch
	public Branch addNewCustomersToExistingBranch(int existingBranchId, List<Customer> customers) {
		return branchDao.addNewCustomersToExistingBranch(existingBranchId, customers);
	}

	// addExistingCustomersToExistingBranch
	public Branch addExistingCustomersToExistingBranch(int existingBranchId, int existingCustomerId) {
		return branchDao.addExistingCustomersToExistingBranch(existingBranchId, existingCustomerId);
	}

	// addNewEmployeesToExistingBranch
	public Branch addNewEmployeesToExistingBranch(int existingBranchId, List<Employee> employees) {
		return branchDao.addNewEmployeesToExistingBranch(existingBranchId, employees);
	}

}
