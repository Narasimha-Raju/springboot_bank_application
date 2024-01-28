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

import com.jsp.springboot_bank_application.dto.Manager;
import com.jsp.springboot_bank_application.service.ManagerService;
import com.jsp.springboot_bank_application.util.ResponseStructure;

@RestController
public class ManagerController {

	@Autowired
	ManagerService managerService;
	
	//Saving Manager
	@PostMapping("saveManager")
	public ResponseEntity<ResponseStructure<Manager>> saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}
	
	//Deleting Manager
	@DeleteMapping("deleteManager")
	public ResponseEntity<ResponseStructure<Manager>> deleteManagerById(@RequestParam int managerId) {
		return managerService.deleteManagerById(managerId);
	}
	
	//Fetching Manager
	@GetMapping("fetchManager")
	public ResponseEntity<ResponseStructure<Manager>> fetchManagerById(@RequestParam int managerId) {
		return managerService.fetchManagerById(managerId);
	}
	
	//Updating Manager
	@PutMapping("updateManager")
	public ResponseEntity<ResponseStructure<Manager>> updateManager(@RequestParam int managerId,@RequestBody Manager manager) {
		return managerService.updateManager(managerId, manager);
	}
}
