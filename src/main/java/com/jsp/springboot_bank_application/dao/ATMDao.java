package com.jsp.springboot_bank_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_bank_application.dto.ATM;
import com.jsp.springboot_bank_application.repo.ATMRepository;

@Repository
public class ATMDao {

	@Autowired
	ATMRepository atmRepository;
	
	//saving ATM
	public ATM saveATM(ATM atm) {
		return atmRepository.save(atm);
	}
	
	//Deleting ATM
	public ATM deleteATMById(int atmId) {
		ATM atm=atmRepository.findById(atmId).get();
		atmRepository.deleteById(atmId);
		return atm;
	}
	
	//Fetching ATM
	public ATM fetchATMById(int atmId) {
		Optional<ATM> optional=atmRepository.findById(atmId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	//Updating ATM
	public ATM updateATM(int atmId,ATM atm) {
		atm.setAtmId(atmId);
		return atmRepository.save(atm);
	}
}
