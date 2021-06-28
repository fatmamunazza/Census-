package com.censusapp.exceptions;

public class DetailsNotFoundException extends Exception {
	public DetailsNotFoundException() {
		super("Application ID not found");		
	}	
}
