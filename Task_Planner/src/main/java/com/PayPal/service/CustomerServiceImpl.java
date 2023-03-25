package com.PayPal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PayPal.exception.CustomerException;
import com.PayPal.model.CurrentUserSession;
import com.PayPal.model.Customer;
import com.PayPal.repository.CustomerDao;
import com.PayPal.repository.SessionDao;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired(required = false)
	private CustomerDao cDao ; 
	
	
	@Autowired(required = false)
	private SessionDao sDao; 
	
	
	
	
	
	@Override
	public Customer createCustomer(Customer customer) throws CustomerException {
		
	Customer existingCustomer =	cDao.findByMobileNo(customer.getMobileNo());
	
	if(existingCustomer != null) {
		throw new CustomerException("Customer Already Registered with Mobile number");
	}
	
		return cDao.save(customer);
	}
	
	
	

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException {
		
	CurrentUserSession loggedInUser = 	sDao.findByUuid(key) ; 
		if(loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer ");
		}
		
		if(customer.getCustomerId() == loggedInUser.getUserId()) {
			
			return cDao.save(customer);
		}else {
			throw new CustomerException("Invalid customer Details , please login first ");
		}
	}

}
