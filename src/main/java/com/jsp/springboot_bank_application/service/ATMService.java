package com.jsp.springboot_bank_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_bank_application.dao.ATMDao;
import com.jsp.springboot_bank_application.dto.ATM;
import com.jsp.springboot_bank_application.exception.ATMIdNotFound;
import com.jsp.springboot_bank_application.util.ResponseStructure;

@Service
public class ATMService {

	@Autowired
	ATMDao atmDao;
	
	//saving ATM
	public ResponseEntity<ResponseStructure<ATM>> saveATM(ATM atm) {
		ResponseStructure<ATM> responseStructure=new ResponseStructure<ATM>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully ATM details Inserted into DataBase");
		responseStructure.setData(atmDao.saveATM(atm));
		return new ResponseEntity<ResponseStructure<ATM>>(responseStructure, HttpStatus.CREATED);
	}
	
	//Deleting ATM
	public ResponseEntity<ResponseStructure<ATM>> deleteATMById(int atmId) {
		ResponseStructure<ATM> responseStructure=new ResponseStructure<ATM>();
		ATM atm=atmDao.fetchATMById(atmId);
		if (atm!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Deleted from DataBase");
			responseStructure.setData(atmDao.deleteATMById(atmId));
			return new ResponseEntity<ResponseStructure<ATM>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ATMIdNotFound();
		}
	}
	
	//Fetching ATM
	public ResponseEntity<ResponseStructure<ATM>> fetchATMById(int atmId) {
		ResponseStructure<ATM> responseStructure=new ResponseStructure<ATM>();
		ATM atm=atmDao.fetchATMById(atmId);
		if (atm!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Fetched from DataBase");
			responseStructure.setData(atmDao.fetchATMById(atmId));
			return new ResponseEntity<ResponseStructure<ATM>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new ATMIdNotFound();
		}
	}
	
	//Updating ATM
	public ResponseEntity<ResponseStructure<ATM>> updateATM(int atmId,ATM atm) {
		ResponseStructure<ATM> responseStructure=new ResponseStructure<ATM>();
		ATM atm2=atmDao.fetchATMById(atmId);
		if (atm2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully ATM Updated in DataBase");
			responseStructure.setData(atmDao.updateATM(atmId, atm));
			return new ResponseEntity<ResponseStructure<ATM>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ATMIdNotFound();
		}
	}
}
