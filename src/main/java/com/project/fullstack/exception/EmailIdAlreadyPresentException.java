package com.project.fullstack.exception;

@SuppressWarnings("serial")
public class EmailIdAlreadyPresentException extends Exception{
	public EmailIdAlreadyPresentException(String message){
		super(message);
	}
}
