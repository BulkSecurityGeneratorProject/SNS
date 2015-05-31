package com.sas.webapp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sas.webapp.domain.SASResponse;

@ControllerAdvice
public class SASControllerAdvice {

	
	@ExceptionHandler(Exception.class)
	public SASResponse handleException(Exception e){
		System.err.println(e.getMessage());
		return SASResponse.createErrorResponse();
	}
}
