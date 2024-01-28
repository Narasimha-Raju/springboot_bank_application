package com.jsp.springboot_bank_application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_bank_application.dto.ATM;
import com.jsp.springboot_bank_application.dto.Address;
import com.jsp.springboot_bank_application.dto.Branch;
import com.jsp.springboot_bank_application.dto.Customer;
import com.jsp.springboot_bank_application.dto.Employee;
import com.jsp.springboot_bank_application.dto.Manager;
import com.jsp.springboot_bank_application.repo.BranchRepository;

@Repository
public class BranchDao {

	@Autowired
	BranchRepository branchRepository;

	@Autowired
	AddressDao addressDao;
	
	@Autowired
	CustomerDao  customerDao;

	// Saving Branch
	public Branch saveBranch(Branch branch) {
		return branchRepository.save(branch);
	}

	// Deleting Branch
	public Branch deleteBranchById(int branchId) {
		Branch branch = branchRepository.findById(branchId).get();
		branchRepository.deleteById(branchId);
		return branch;
	}

	// Fetching Branch
	public Branch fetchBranchById(int branchId) {
		Optional<Branch> optional=branchRepository.findById(branchId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	// Updating Branch
	public Branch updateBranch(int branchId, Branch branch) {
		branch.setBranchId(branchId);
		return branchRepository.save(branch);
	}

	// addExistingAddressToExistingBranch
	public Branch addExistingAddressToExistingBranch(int existingBranchId, int existingAddressId) {
		Branch branch = fetchBranchById(existingBranchId);
		Address address = addressDao.fetchAddressById(existingAddressId);
		branch.setAddress(address);
		return saveBranch(branch);
	}

	// addNewAddressToExistingBranch
	public Branch addNewAddressToExistingBranch(int existingBranchId, Address newAddress) {
		Branch branch = fetchBranchById(existingBranchId);
		branch.setAddress(newAddress);
		return saveBranch(branch);
	}
	
	//addNewManagerToExistingBranch
	public Branch addNewManagerToExistingBranch(int existingBranchId,Manager manager) {
		Branch branch=fetchBranchById(existingBranchId);
		branch.setManager(manager);
		return saveBranch(branch);
	}
	
	//addNewAtmsToExistingBranch
	public Branch addNewAtmsToExistingBranch(int existingBranchId, List<ATM> atms) {
		Branch branch=fetchBranchById(existingBranchId);
		branch.setAtms(atms);
		return saveBranch(branch);
	}
	
	//addNewCustomersToExistingBranch
	public Branch addNewCustomersToExistingBranch(int existingBranchId, List<Customer> customers) {
		Branch branch=fetchBranchById(existingBranchId);
//		List<Customer> customerList=branch.getCustomers();
//		customerList.addAll(customers);
//		branch.setCustomers(customerList);
		customers.addAll(branch.getCustomers());
		branch.setCustomers(customers);
		return saveBranch(branch);
	}
	
	//addExistingCustomersToExistingBranch
	public Branch addExistingCustomersToExistingBranch(int existingBranchId,int existingCustomerId) {
		Branch branch=fetchBranchById(existingBranchId);
		Customer customer=customerDao.fetchCustomerById(existingCustomerId);
		branch.getCustomers().add(customer);
		return saveBranch(branch);
	}
	
	//addNewEmployeesToExistingBranch
	public Branch addNewEmployeesToExistingBranch(int existingBranchId,List<Employee> employees) {
		Branch branch=fetchBranchById(existingBranchId);
		employees.addAll(branch.getEmployees());
		branch.setEmployees(employees);
		return saveBranch(branch);
	}
}
