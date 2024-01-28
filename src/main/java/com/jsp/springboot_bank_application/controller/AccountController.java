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

import com.jsp.springboot_bank_application.dto.Account;
import com.jsp.springboot_bank_application.service.AccountService;
import com.jsp.springboot_bank_application.util.ResponseStructure;

@RestController
public class AccountController {
	@Autowired
	AccountService accountService;

	// saving Account
	@PostMapping("saveAccount")
	public ResponseEntity<ResponseStructure<Account>> saveAccount(@RequestBody Account account) {
		return accountService.saveAccount(account);
	}

	// Deleting Account
	@DeleteMapping("deleteAccount")
	public ResponseEntity<ResponseStructure<Account>> deleteAccountById(@RequestParam int accountId) {
		return accountService.deleteAccountById(accountId);
	}

	// Fetching Account
	@GetMapping("fetchAccount")
	public ResponseEntity<ResponseStructure<Account>> fetchAccountById(@RequestParam int accountId) {
		return accountService.fetchAccountById(accountId);
	}

	// Updating Account
	@PutMapping("updateAccount")
	public ResponseEntity<ResponseStructure<Account>> updateAccount(@RequestParam int accountId,@RequestBody Account account) {
		return accountService.updateAccount(accountId, account);
	}
}
