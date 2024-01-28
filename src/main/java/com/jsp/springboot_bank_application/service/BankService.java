package com.jsp.springboot_bank_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_bank_application.dao.BankDao;
import com.jsp.springboot_bank_application.dto.Bank;
import com.jsp.springboot_bank_application.exception.BankIdNotFound;
import com.jsp.springboot_bank_application.util.ResponseStructure;

@Service
public class BankService {

	@Autowired
	BankDao bankDao;

	// Saving Bank
	public ResponseEntity<ResponseStructure<Bank>> saveBank(Bank bank) {
		ResponseStructure<Bank> responseStructure=new ResponseStructure<Bank>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Bank details Inserted into DataBase");
		responseStructure.setData(bankDao.saveBank(bank));
		return new ResponseEntity<ResponseStructure<Bank>>(responseStructure, HttpStatus.CREATED);
	}

	// Deleting Bank
	public ResponseEntity<ResponseStructure<Bank>> deleteBankById(int bankId) {
		ResponseStructure<Bank> responseStructure=new ResponseStructure<Bank>();
		Bank bank=bankDao.fetchBankById(bankId);
		if (bank!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Deleted from DataBase");
			responseStructure.setData(bankDao.deleteBankById(bankId));
			return new ResponseEntity<ResponseStructure<Bank>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BankIdNotFound();
		}
	}

	// Fetching Bank
	public ResponseEntity<ResponseStructure<Bank>> fetchBankById(int bankId) {
		ResponseStructure<Bank> responseStructure=new ResponseStructure<Bank>();
		Bank bank=bankDao.fetchBankById(bankId);
		if (bank!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Fetched from DataBase");
			responseStructure.setData(bankDao.fetchBankById(bankId));
			return new ResponseEntity<ResponseStructure<Bank>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new BankIdNotFound();
		}
	}

	// Updating Bank
	public ResponseEntity<ResponseStructure<Bank>> updateBank(int bankId, Bank bank) {
		ResponseStructure<Bank> responseStructure=new ResponseStructure<Bank>();
		Bank bank2=bankDao.fetchBankById(bankId);
		if (bank2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Bank Updated DataBase");
			responseStructure.setData(bankDao.updateBank(bankId, bank));
			return new ResponseEntity<ResponseStructure<Bank>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BankIdNotFound();
		}
	}

	// addExistingBranchesToExistingBank
//	public Bank addExistingBranchesToExistingBank(int existingBankId,int existingBranchId) {
//		return bankDao.addExistingBranchesToExistingBank(existingBankId, existingBranchId);
//	}
}
