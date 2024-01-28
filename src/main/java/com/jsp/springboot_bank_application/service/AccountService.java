package com.jsp.springboot_bank_application.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_bank_application.dao.AccountDao;
import com.jsp.springboot_bank_application.dto.Account;
import com.jsp.springboot_bank_application.exception.AccountIdNotFound;
import com.jsp.springboot_bank_application.util.ResponseStructure;

@Service
public class AccountService {

	@Autowired
	AccountDao accountDao;

	// saving Account
	public ResponseEntity<ResponseStructure<Account>> saveAccount(Account account) {
		ResponseStructure<Account> responseStructure=new ResponseStructure<Account>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Account details Inserted into DataBase");
		responseStructure.setData(accountDao.saveAccount(account));
		return new ResponseEntity<ResponseStructure<Account>>(responseStructure, HttpStatus.CREATED);
	}

	// Deleting Account
	public ResponseEntity<ResponseStructure<Account>> deleteAccountById(int accountId) {
		ResponseStructure<Account> responseStructure=new ResponseStructure<Account>();
		Account account=accountDao.fetchAccountById(accountId);
		if (account!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Deleted from DataBase");
			responseStructure.setData(accountDao.deleteAccountById(accountId));
			return new ResponseEntity<ResponseStructure<Account>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AccountIdNotFound();
		}
	}

	// Fetching Account
	public ResponseEntity<ResponseStructure<Account>> fetchAccountById(int accountId) {
		ResponseStructure<Account> responseStructure=new ResponseStructure<Account>();
		Account account=accountDao.fetchAccountById(accountId);
		if (account!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Fetched from DataBase");
			responseStructure.setData(accountDao.fetchAccountById(accountId));
			return new ResponseEntity<ResponseStructure<Account>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new AccountIdNotFound();
		}
	}

	// Updating Account
	public ResponseEntity<ResponseStructure<Account>> updateAccount(int accountId, Account account) {
		ResponseStructure<Account> responseStructure=new ResponseStructure<Account>();
		Account account2=accountDao.fetchAccountById(accountId);
		if (account2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Account Updated in DataBase");
			responseStructure.setData(accountDao.updateAccount(accountId, account));
			return new ResponseEntity<ResponseStructure<Account>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AccountIdNotFound();
		}
	}
}
