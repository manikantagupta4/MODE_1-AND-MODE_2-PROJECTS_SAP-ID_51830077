package com.bankapp.model.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class ExceptionHandlerController {
	
	
	/*@ExceptionHandler(InSuffientFundException.class)
	public ModelAndView AmountNotsuffException(InSuffientFundException ex){
		ModelAndView mp=new ModelAndView();
		mp.addObject("ex", ex);
		mp.setViewName("errorpage");
		return mp;
	}
		@ExceptionHandler(AccountNotFoundException.class)
		public ModelAndView AccountNotFoundExcept(AccountNotFoundException ex1){
			ModelAndView mp1=new ModelAndView();
			mp1.addObject("ex1", ex1);
			mp1.setViewName("errorpage");
			return mp1;
		}
	
	
	
	*/
	
}
