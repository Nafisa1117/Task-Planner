package com.PayPal.service;

import com.PayPal.exception.CustomerException;
import com.PayPal.model.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer , String key ) throws CustomerException;
}
