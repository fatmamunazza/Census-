package com.censusapp.exceptions;

import java.sql.SQLException;

import com.censusapp.constant.Constants;

public class AddHeadMemberException extends Exception{
	public AddHeadMemberException(SQLException e) {
		super(Constants.failedToAddHeadMember + " : " + e);
	}
}
