package com.PayPal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PayPal.model.CurrentUserSession;

public interface SessionDao extends JpaRepository<CurrentUserSession, Integer>{

	
	public CurrentUserSession findByUuid(String uuid) ; 
	
}
