package com.bankapp.model.exceptions;

public class InSuffientFundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public InSuffientFundException(String message) {
		super(message);
	}

}
