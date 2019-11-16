package com.bankapp.model.exceptions;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandlerController {
	@ExceptionHandler(AccountNotFoundException.class)
	public ErrorDetails HandlerForAccountNotFoundException(AccountNotFoundException ex,WebRequest req){
		ErrorDetails details=new ErrorDetails(ex.getMessage(), req.getDescription(false), LocalDateTime.now());
		return details;
		
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ErrorDetails HandlerForUserNotFoundException(UserNotFoundException ex,WebRequest req){
		ErrorDetails details=new ErrorDetails(ex.getMessage(), req.getDescription(false), LocalDateTime.now());
		return details;
		
	}
	@ExceptionHandler(InSuffientFundException.class)
	public ErrorDetails HandlerForAmountNotFoundException(InSuffientFundException ex,WebRequest req){
		ErrorDetails details=new ErrorDetails(ex.getMessage(), req.getDescription(false), LocalDateTime.now());
		return details;
		
	}
}
