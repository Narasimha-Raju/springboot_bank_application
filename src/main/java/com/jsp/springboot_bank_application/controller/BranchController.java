package com.jsp.springboot_bank_application.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_bank_application.dto.ATM;
import com.jsp.springboot_bank_application.dto.Address;
import com.jsp.springboot_bank_application.dto.Branch;
import com.jsp.springboot_bank_application.dto.Customer;
import com.jsp.springboot_bank_application.dto.Employee;
import com.jsp.springboot_bank_application.dto.Manager;
import com.jsp.springboot_bank_application.service.BranchService;
import com.jsp.springboot_bank_application.util.ResponseStructure;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;

	// Saving Branch
	@PostMapping("saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	// Deleting Branch
	@DeleteMapping("deleteBranch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(@RequestParam int branchId) {
		return branchService.deleteBranchById(branchId);
	}

	// Fetching Branch
	@GetMapping("fetchBranch")
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(@RequestParam int branchId) {
		return branchService.fetchBranchById(branchId);
	}

	// Updating Branch
	@PutMapping("updateBranch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestParam int branchId,@RequestBody Branch branch) {
		return branchService.updateBranch(branchId, branch);
	}

	// addExistingAddressToExistingBranch
	@PatchMapping("addExistingAddressToExistingBranch")
	public Branch addExistingAddressToExistingBranch(@RequestParam int existingBranchId,
			@RequestParam int existingAddressId) {
		return branchService.addExistingAddressToExistingBranch(existingBranchId, existingAddressId);
	}

	// addNewAddressToExistingBranch
	@PutMapping("addNewAddressToExistingBranch")
	public Branch addNewAddressToExistingBranch(@RequestParam int existingBranchId, @RequestBody Address newAddress) {
		return branchService.addNewAddressToExistingBranch(existingBranchId, newAddress);
	}

	// addNewManagerToExistingBranch
	@PutMapping("addNewManagerToExistingBranch")
	public Branch addNewManagerToExistingBranch(@RequestParam int existingBranchId, @RequestBody Manager manager) {
		return branchService.addNewManagerToExistingBranch(existingBranchId, manager);
	}

	// addNewAtmsToExistingBranch
	@PutMapping("addNewAtmsToExistingBranch")
	public Branch addNewAtmsToExistingBranch(@RequestParam int existingBranchId, @RequestBody List<ATM> atms) {
		return branchService.addNewAtmsToExistingBranch(existingBranchId, atms);
	}

	// addNewCustomersToExistingBranch
	@PutMapping("addNewCustomersToExistingBranch")
	public Branch addNewCustomersToExistingBranch(@RequestParam int existingBranchId,
			@RequestBody List<Customer> customers) {
		return branchService.addNewCustomersToExistingBranch(existingBranchId, customers);
	}

	// addNewEmployeesToExistingBranch
	@PutMapping("addNewEmployeesToExistingBranch")
	public Branch addNewEmployeesToExistingBranch(@RequestParam int existingBranchId,
			@RequestBody List<Employee> employees) {
		return branchService.addNewEmployeesToExistingBranch(existingBranchId, employees);
	}


	// addExistingCustomersToExistingBranch
	@PatchMapping("addExistingCustomersToExistingBranch")
	public Branch addExistingCustomersToExistingBranch(@RequestParam int existingBranchId,@RequestParam int existingCustomerId) {
		return branchService.addExistingCustomersToExistingBranch(existingBranchId, existingCustomerId);
	}
}
