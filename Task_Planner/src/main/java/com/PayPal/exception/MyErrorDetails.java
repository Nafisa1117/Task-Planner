package com.PayPal.exception;

import java.time.LocalDateTime;

public class MyErrorDetails {

private LocalDateTime timestamp ; 
	
	private String Message ; 
	
	private String details;  
	
	public MyErrorDetails() {
		// TODO Auto-generated constructor stub
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "MyErrorDetails [timestamp=" + timestamp + ", Message=" + Message + ", details=" + details + "]";
	}

	public MyErrorDetails(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		Message = message;
		this.details = details;
	}
	
	
	
	
	
}
