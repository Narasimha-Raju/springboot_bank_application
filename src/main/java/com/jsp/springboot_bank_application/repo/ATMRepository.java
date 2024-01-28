package com.jsp.springboot_bank_application.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_bank_application.dto.ATM;

public interface ATMRepository extends JpaRepository<ATM, Integer>{

}
