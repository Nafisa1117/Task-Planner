package com.PayPal.service;

import javax.security.auth.login.LoginException;


import com.PayPal.model.LoginDTO;

public interface LoginService {

	public String logIntoAccount(LoginDTO dto ) throws LoginException;
	
	public String logOutFromAccount(String key ) throws LoginException;
	
}
