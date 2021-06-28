package com.censusapp.exceptions;

import com.censusapp.constant.Constants;

public class DbConnectionException extends Exception{

	public DbConnectionException() {
		super(Constants.databaseNotConnectted);
	}
}
