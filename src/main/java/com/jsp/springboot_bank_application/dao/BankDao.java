package com.jsp.springboot_bank_application.dao;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Repository;

import com.jsp.springboot_bank_application.dto.Bank;
import com.jsp.springboot_bank_application.repo.BankRepository;

@Repository
public class BankDao {
	@Autowired
	BankRepository bankRepository;
	
	@Autowired
	BranchDao branchDao;
	
	//Saving Bank
	public Bank saveBank(Bank bank) {
		return bankRepository.save(bank);
	}
	
	//Deleting Bank
	public Bank deleteBankById(int bankId) {
		Bank bank=bankRepository.findById(bankId).get();
		bankRepository.deleteById(bankId);
		return bank;
	}
	
	//Fetching Bank
	public Bank fetchBankById(int bankId) {
		Optional<Bank> optional=bankRepository.findById(bankId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	//Updating Bank
	public Bank updateBank(int bankId,Bank bank) {
		bank.setBankId(bankId);
		return bankRepository.save(bank);
	}
	
	//addExistingBranchesToExistingBank
//	public Bank addExistingBranchesToExistingBank(int existingBankId,int existingBranchId) {
//		Bank bank=fetchBankById(existingBankId);
//		List<Branch> branch=branchDao.fetchBranchById(existingBranchId);
//		bank.setBranchs(branch);
//		return saveBank(bank);
//	}
}
