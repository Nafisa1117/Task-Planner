package com.PayPal.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PayPal.model.CurrentUserSession;
import com.PayPal.model.Customer;
import com.PayPal.model.LoginDTO;
import com.PayPal.repository.CustomerDao;
import com.PayPal.repository.SessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl  implements LoginService{
	
	@Autowired(required = false)
	private CustomerDao cDao ; 
	
	
	@Autowired(required = false)
	private SessionDao sDao;

	
	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {
	
		Customer existingCutomer = cDao.findByMobileNo(dto.getMobileNo());
		
		if(existingCutomer == null) {
			throw new LoginException("Please Enter a valid mobile numnber");
		}
		
		
		Optional<CurrentUserSession> validCustomerSeeionOpt = sDao.findById(existingCutomer.getCustomerId());
		
		
		if(validCustomerSeeionOpt.isPresent()) {
			throw new LoginException("User already Logged In with this number");
		}
		
		if(existingCutomer.getPassword().equals(dto.getPassword())) {
			
			String key = RandomString.make(6);
			
			CurrentUserSession currentUserSeeion = new CurrentUserSession(existingCutomer.getCustomerId(),key,LocalDateTime.now());
			
			sDao.save(currentUserSeeion);
			
			return currentUserSeeion.toString();
			 
		}else {
			throw new LoginException("Please Enter a valid password");
		}
		
		
		
	
	}


	@Override
	public String logOutFromAccount(String key) throws LoginException {
		
		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		sDao.delete(validCustomerSession);
		
		
		return "Logged Out !";
	}



	
	
	
	


	
}





















