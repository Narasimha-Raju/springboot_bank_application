package com.jsp.springboot_bank_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_bank_application.dto.Account;
import com.jsp.springboot_bank_application.repo.AccountRepository;

@Repository
public class AccountDao {
	@Autowired
	AccountRepository accountRepository;
	
	//saving Account
	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}
	
	//Deleting Account
	public Account deleteAccountById(int accountId) {
		Account account=accountRepository.findById(accountId).get();
		accountRepository.deleteById(accountId);
		return account;
	}
	
	//Fetching Account
	public Account fetchAccountById(int accountId) {
//		return accountRepository.findById(accountId).get();
		Optional<Account> optional=accountRepository.findById(accountId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	//Updating Account
	public Account updateAccount(int accountId,Account account) {
		account.setAccountId(accountId);
		return accountRepository.save(account);
	}
}










