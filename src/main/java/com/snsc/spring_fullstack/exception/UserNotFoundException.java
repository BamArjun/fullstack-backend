package com.snsc.spring_fullstack.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(Long id) {
		super("could not found the user with is"+id);
		
	}

}
