package com.PayPal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PayPal.exception.CustomerException;
import com.PayPal.model.Customer;
import com.PayPal.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired(required = false)
	private CustomerService cService; 
	
	
	
@PostMapping("/customers")	
public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws CustomerException{
	
	Customer savedCustomer  = cService.createCustomer(customer);
	
	
	return new ResponseEntity<Customer>(savedCustomer,HttpStatus.CREATED);
	
}
	
@PutMapping("/customers")
public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer ,@RequestParam(required = false) String key ) throws CustomerException{
	
	Customer updateCustomer = cService.updateCustomer(customer, key);
	
	
	return new ResponseEntity<Customer>(updateCustomer,HttpStatus.OK);
	
}
	

}
