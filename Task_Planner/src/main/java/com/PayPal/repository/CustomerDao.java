package com.PayPal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PayPal.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

	
	public Customer findByMobileNo(String mobileNo);

}
