package com.censusapp.exceptions;

import java.sql.SQLException;

import com.censusapp.constant.Constants;

public class AddEntryException extends Exception{
	private static final long serialVersionUID = 1L;

	public AddEntryException(SQLException e) {
		super(Constants.failedToAddMember + " : " + e);
	}
}