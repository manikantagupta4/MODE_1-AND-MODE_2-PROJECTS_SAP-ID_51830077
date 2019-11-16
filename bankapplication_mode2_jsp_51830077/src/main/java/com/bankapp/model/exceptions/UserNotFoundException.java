package com.bankapp.model.exceptions;

public class UserNotFoundException extends RuntimeException{
public UserNotFoundException(String message) {
	super(message);
}
}
