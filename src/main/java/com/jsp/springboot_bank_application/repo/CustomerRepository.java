package com.jsp.springboot_bank_application.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_bank_application.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
