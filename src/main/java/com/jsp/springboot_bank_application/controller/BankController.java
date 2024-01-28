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

import com.jsp.springboot_bank_application.dto.Bank;
import com.jsp.springboot_bank_application.service.BankService;
import com.jsp.springboot_bank_application.util.ResponseStructure;

@RestController
public class BankController {

	@Autowired
	BankService bankService;

	// Saving Bank
	@PostMapping("saveBank")
	public ResponseEntity<ResponseStructure<Bank>> saveBank(@RequestBody Bank bank) {
		return bankService.saveBank(bank);
	}

	// Deleting Bank
	@DeleteMapping("deleteBank")
	public ResponseEntity<ResponseStructure<Bank>> deleteBankById(@RequestParam int bankId) {
		return bankService.deleteBankById(bankId);
	}

	// Fetching Bank
	@GetMapping("fetchBank")
	public ResponseEntity<ResponseStructure<Bank>> fetchBankById(@RequestParam int bankId) {
		return bankService.fetchBankById(bankId);
	}

	// Updating Bank
	@PutMapping("updateBank")
	public ResponseEntity<ResponseStructure<Bank>> updateBank(@RequestParam int bankId, @RequestBody Bank bank) {
		return bankService.updateBank(bankId, bank);
	}

	// addExistingBranchesToExistingBank
//	@PatchMapping("addExistingBranchesToExistingBank")
//	public Bank addExistingBranchesToExistingBank(@RequestParam int existingBankId,@RequestParam int existingBranchId) {
//		return bankService.addExistingBranchesToExistingBank(existingBankId, existingBranchId);
//	}
}
