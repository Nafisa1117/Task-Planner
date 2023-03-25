package com.PayPal.controller;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PayPal.model.LoginDTO;
import com.PayPal.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired(required = false)
	private LoginService customerLogin;
	
	
	@PostMapping("/login")
	public ResponseEntity<String> logIntoAccount(@RequestBody LoginDTO dto ) throws LoginException{
		
		String result = customerLogin.logIntoAccount(dto);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
		
	}
	
	
	@PostMapping("/logout")
	public ResponseEntity<String> logOutFromAccount(@RequestParam(required = false) String key ) throws LoginException{
		
		String result = customerLogin.logOutFromAccount(key);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}

}
