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

import com.jsp.springboot_bank_application.dto.ATM;
import com.jsp.springboot_bank_application.service.ATMService;
import com.jsp.springboot_bank_application.util.ResponseStructure;

@RestController
public class ATMController {
	@Autowired
	ATMService atmService;
	
	//saving ATM
	@PostMapping("saveATM")
	public ResponseEntity<ResponseStructure<ATM>> saveATM(@RequestBody ATM atm) {
		return atmService.saveATM(atm);
	}
	
	//Deleting ATM
	@DeleteMapping("deleteATM")
	public ResponseEntity<ResponseStructure<ATM>> deleteATMById(@RequestParam int atmId) {
		return atmService.deleteATMById(atmId);
	}
	
	//Fetching ATM
	@GetMapping("fetchATM")
	public ResponseEntity<ResponseStructure<ATM>> fetchATMById(@RequestParam int atmId) {
		return atmService.fetchATMById(atmId);
	}
	
	//Updating ATM
	@PutMapping("updateATM")
	public ResponseEntity<ResponseStructure<ATM>> updateATM(@RequestParam int atmId,@RequestBody ATM atm) {
		return atmService.updateATM(atmId, atm);
	}
}
