package com.jsp.springboot_bank_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_bank_application.dao.ManagerDao;
import com.jsp.springboot_bank_application.dto.Manager;
import com.jsp.springboot_bank_application.exception.ManagerIdNotFound;
import com.jsp.springboot_bank_application.util.ResponseStructure;

@Service
public class ManagerService {
	
	@Autowired
	ManagerDao managerDao;
	
	//Saving Manager
	public ResponseEntity<ResponseStructure<Manager>> saveManager(Manager manager) {
		ResponseStructure<Manager> responseStructure=new ResponseStructure<Manager>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Manager details Inserted into DataBase");
		responseStructure.setData(managerDao.saveManager(manager));
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.CREATED);
	}
	
	//Deleting Manager
	public ResponseEntity<ResponseStructure<Manager>> deleteManagerById(int managerId) {
		ResponseStructure<Manager> responseStructure=new ResponseStructure<Manager>();
		Manager manager=managerDao.fetchManagerById(managerId);
		if (manager!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Deleted from DataBase");
			responseStructure.setData(managerDao.deleteManagerById(managerId));
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ManagerIdNotFound();
		}
	}
	
	//Fetching Manager
	public ResponseEntity<ResponseStructure<Manager>> fetchManagerById(int managerId) {
		ResponseStructure<Manager> responseStructure=new ResponseStructure<Manager>();
		Manager manager=managerDao.fetchManagerById(managerId);
		if (manager!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Fetched from DataBase");
			responseStructure.setData(managerDao.fetchManagerById(managerId));
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new ManagerIdNotFound();
		}
	}
	
	//Updating Manager
	public ResponseEntity<ResponseStructure<Manager>> updateManager(int managerId, Manager manager) {
		ResponseStructure<Manager> responseStructure=new ResponseStructure<Manager>();
		Manager manager2=managerDao.fetchManagerById(managerId);
		if (manager2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Manager Details Updated in DataBase");
			responseStructure.setData(managerDao.updateManager(managerId, manager));
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ManagerIdNotFound();
		}
	}
}
