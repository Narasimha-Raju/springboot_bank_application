package com.jsp.springboot_bank_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_bank_application.dto.Manager;
import com.jsp.springboot_bank_application.repo.ManagerRepository;

@Repository
public class ManagerDao {

	@Autowired
	ManagerRepository managerRepository;
	
	//Saving Manager
	public Manager saveManager(Manager manager) {
		return managerRepository.save(manager);
	}
	
	//Deleting Manager
	public Manager deleteManagerById(int managerId) {
		Manager manager=managerRepository.findById(managerId).get();
		managerRepository.deleteById(managerId);
		return manager;
	}
	
	//Fetching Manager
	public Manager fetchManagerById(int managerId) {
		Optional<Manager> optional=managerRepository.findById(managerId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	//Updating Manager
	public Manager updateManager(int managerId, Manager manager) {
		manager.setManagerId(managerId);
		return managerRepository.save(manager);
	}
}
